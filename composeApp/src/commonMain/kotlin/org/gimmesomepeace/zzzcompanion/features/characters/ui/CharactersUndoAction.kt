package org.gimmesomepeace.zzzcompanion.features.characters.ui

import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId


sealed interface CharactersUndoAction {
    data class Add(val characterId: CharacterId) : CharactersUndoAction
    data class Remove(val characterId: CharacterId) : CharactersUndoAction
}