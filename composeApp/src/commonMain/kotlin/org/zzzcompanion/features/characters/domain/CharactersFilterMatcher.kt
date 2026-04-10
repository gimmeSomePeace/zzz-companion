package org.zzzcompanion.features.characters.domain

import org.zzzcompanion.features.characters.data.entities.Character


class CharactersFilterMatcher {
    fun matches(
        character: Character,
        filters: CharactersFilters
    ) : Boolean {
         return (filters.query.isBlank() || character.name.contains(filters.query, ignoreCase = true)) &&
                (filters.factionId == null || character.factionId == filters.factionId) &&
                (filters.attributeId == null || character.attributeId == filters.attributeId) &&
                (filters.specialityId == null || character.specialityId == filters.specialityId) &&
                (filters.rarityId == null || character.rarityId == filters.rarityId)
    }
}