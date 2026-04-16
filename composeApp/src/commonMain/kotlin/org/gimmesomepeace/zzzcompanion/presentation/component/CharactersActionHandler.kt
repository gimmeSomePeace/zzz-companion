package org.gimmesomepeace.zzzcompanion.presentation.component

import org.gimmesomepeace.zzzcompanion.domain.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.presentation.ui.character.CharactersAction
import org.gimmesomepeace.zzzcompanion.presentation.ui.character.CharactersUndoAction


class CharactersActionHandler(
    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase
) {
    private var lastUndo: CharactersUndoAction? = null

    fun handle(action: CharactersAction) {
        when (action) {
            is CharactersAction.Add -> {
                if (addCharacterToOwnedUseCase.execute(action.characterId)) {
                    lastUndo = CharactersUndoAction.Remove(characterId = action.characterId)
                }
            }
            is CharactersAction.Remove -> {
                TODO("not implemented")
            }
            is CharactersAction.Undo -> undo()
        }
    }

    private fun undo() {
//        when (val action = lastUndo) {
//            is CharactersUndoAction.Add -> repository.remove(action.characterId)
//            is CharactersUndoAction.Remove -> repository.add(action.characterId)
//            null -> {}
//        }
//        lastUndo = null
    }
}