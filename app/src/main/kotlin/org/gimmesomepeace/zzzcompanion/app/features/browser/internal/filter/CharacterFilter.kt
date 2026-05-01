package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter

import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem


fun List<CharacterListItem>.filterBy(filters: FiltersState): List<CharacterListItem> = this.filter {
         (filters.query.isBlank() || it.name.contains(filters.query, ignoreCase = true)) &&
            (filters.factionId == null || it.factionId == filters.factionId) &&
            (filters.attributeId == null || it.attributeId == filters.attributeId) &&
            (filters.specialityId == null || it.specialityId == filters.specialityId) &&
            (filters.rarityId == null || it.rarityId == filters.rarityId)
}
