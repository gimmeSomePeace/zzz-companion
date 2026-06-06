package me.gimmesomepeace.zzzcompanion.catalog

import me.gimmesomepeace.zzzcompanion.core.character.CharacterId

sealed interface CharactersCatalogIntent {
    data class GoToCharacterDetails(
        val id: CharacterId,
    ) : CharactersCatalogIntent

    data class AddCharacterToOwned(
        val id: CharacterId,
    ) : CharactersCatalogIntent
}
