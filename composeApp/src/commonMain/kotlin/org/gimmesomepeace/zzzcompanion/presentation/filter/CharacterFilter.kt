package org.gimmesomepeace.zzzcompanion.presentation.filter

import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterContext


fun List<CharacterContext>.filterBy(filters: FiltersState): List<CharacterContext> = this.filter {
         (filters.query.isBlank() || it.character.name.contains(filters.query, ignoreCase = true)) &&
            (filters.factionId == null || it.character.factionId == filters.factionId) &&
            (filters.attributeId == null || it.character.attributeId == filters.attributeId) &&
            (filters.specialityId == null || it.character.specialityId == filters.specialityId) &&
            (filters.rarityId == null || it.character.rarityId == filters.rarityId)
}
