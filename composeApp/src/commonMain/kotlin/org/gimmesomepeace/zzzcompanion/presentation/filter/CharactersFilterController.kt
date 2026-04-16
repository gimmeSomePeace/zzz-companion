package org.gimmesomepeace.zzzcompanion.presentation.filter

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId

class CharactersFilterController {
    private var _filters = MutableStateFlow(FiltersState())
    val filters: StateFlow<FiltersState> = _filters.asStateFlow()

    fun updateQuery(newQuery: String) { _filters.value = filters.value.copy(query = newQuery) }
    fun updateFactionId(newFactionId: FactionId?) { _filters.value = filters.value.copy(factionId = newFactionId) }
    fun updateAttributeId(newAttributeId: AttributeId?) { _filters.value = filters.value.copy(attributeId = newAttributeId) }
    fun updateRarityId(newRarityId: RarityId?) { _filters.value = filters.value.copy(rarityId = newRarityId) }
    fun updateSpecialityId(newSpecialityId: SpecialityId?) { _filters.value = filters.value.copy(specialityId = newSpecialityId) }
}