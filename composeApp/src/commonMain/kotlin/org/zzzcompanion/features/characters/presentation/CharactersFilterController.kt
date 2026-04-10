package org.zzzcompanion.features.characters.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.AttributeId
import org.zzzcompanion.features.characters.data.entities.FactionId
import org.zzzcompanion.features.characters.data.entities.RarityId
import org.zzzcompanion.features.characters.data.entities.SpecialityId
import org.zzzcompanion.features.characters.domain.CharactersFilters

class CharactersFilterController {
    private var _filters = MutableStateFlow(CharactersFilters())
    val filters: StateFlow<CharactersFilters> = _filters.asStateFlow()

    fun updateQuery(newQuery: String) { _filters.value = filters.value.copy(query = newQuery) }
    fun updateFactionId(newFactionId: FactionId?) { _filters.value = filters.value.copy(factionId = newFactionId) }
    fun updateAttributeId(newAttributeId: AttributeId?) { _filters.value = filters.value.copy(attributeId = newAttributeId) }
    fun updateRarityId(newRarityId: RarityId?) { _filters.value = filters.value.copy(rarityId = newRarityId) }
    fun updateSpecialityId(newSpecialityId: SpecialityId?) { _filters.value = filters.value.copy(specialityId = newSpecialityId) }
}