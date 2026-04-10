package org.zzzcompanion.features.characters.ui

import org.zzzcompanion.features.characters.data.entities.CharacterId

sealed interface CharactersAction {
    data class Add(val characterId: CharacterId) : CharactersAction
    data class Remove(val characterId: CharacterId) : CharactersAction
    object Undo : CharactersAction
}
