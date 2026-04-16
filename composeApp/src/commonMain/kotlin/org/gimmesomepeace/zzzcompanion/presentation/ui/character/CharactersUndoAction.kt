package org.gimmesomepeace.zzzcompanion.presentation.ui.character

import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId


sealed interface CharactersUndoAction {
    data class Add(val characterId: CharacterId) : CharactersUndoAction
    data class Remove(val characterId: CharacterId) : CharactersUndoAction
}