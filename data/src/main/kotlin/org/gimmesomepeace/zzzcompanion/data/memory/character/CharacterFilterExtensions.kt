package org.gimmesomepeace.zzzcompanion.data.memory.character

import org.gimmesomepeace.zzzcompanion.core.character.Character
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters

fun List<Character>.applyFilters(filters: CharacterFilters) = this.filter {
    (filters.query.isBlank() || it.name.contains(filters.query, ignoreCase = true)) &&
    (filters.factionId == null || it.factionId == filters.factionId) &&
    (filters.attributeId == null || it.attributeId == filters.attributeId) &&
    (filters.specialityId == null || it.specialityId == filters.specialityId) &&
    (filters.rarity == null || it.rarity == filters.rarity)
}
