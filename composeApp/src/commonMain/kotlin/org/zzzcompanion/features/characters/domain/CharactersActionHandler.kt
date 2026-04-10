package org.zzzcompanion.features.characters.domain

import org.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.zzzcompanion.features.characters.ui.CharactersAction
import org.zzzcompanion.features.characters.ui.CharactersUndoAction


class CharactersActionHandler(
    private val repository: UserCharacterRepository
) {
    private var lastUndo: CharactersUndoAction? = null

    fun handle(action: CharactersAction) {
        when (action) {
            is CharactersAction.Add -> {
                if (repository.add(action.characterId)) {
                    lastUndo = CharactersUndoAction.Remove(characterId = action.characterId)
                }
            }
            is CharactersAction.Remove -> {
                if (repository.remove(action.characterId)) {
                    lastUndo = CharactersUndoAction.Add(characterId = action.characterId)
                }
            }
            is CharactersAction.Undo -> undo()
        }
    }

    private fun undo() {
        when (val action = lastUndo) {
            is CharactersUndoAction.Add -> repository.remove(action.characterId)
            is CharactersUndoAction.Remove -> repository.add(action.characterId)
            null -> {}
        }
        lastUndo = null
    }
}