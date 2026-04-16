package org.gimmesomepeace.zzzcompanion.presentation.ui.character

import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId


sealed interface CharactersAction {
    data class Add(val characterId: CharacterId) : CharactersAction
    data class Remove(val characterId: CharacterId) : CharactersAction
    object Undo : CharactersAction
}
