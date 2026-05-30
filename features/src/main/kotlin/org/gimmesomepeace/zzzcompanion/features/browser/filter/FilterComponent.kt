package org.gimmesomepeace.zzzcompanion.features.browser.filter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository
import org.gimmesomepeace.zzzcompanion.features.shared.loadAllPages
import kotlin.collections.map

internal class FilterComponent(
    attributeRepository: AttributeReaderRepository,
    specialityRepository: SpecialityReaderRepository,
    factionRepository: FactionReaderRepository,
    onFiltersChange: (SelectedFilters) -> Unit,
    scope: CoroutineScope,
) {
    private val selectedFilters = MutableStateFlow(SelectedFilters())
    private val filterOptions = MutableStateFlow(FilterOptionsState())

    val state = combine(
        selectedFilters,
        filterOptions
    ) { filters, options ->
        FilterState(
            query = filters.query,

            factions = options.factions,
            attributes = options.attributes,
            specialities = options.specialities,
            rarities = options.rarities,

            selectedFaction = options.factions.firstOrNull {
                it is SelectOption.Item && it.value == filters.faction
            } ?: SelectOption.All,
            selectedAttribute = options.attributes.firstOrNull {
                it is SelectOption.Item && it.value == filters.attribute
            } ?: SelectOption.All,
            selectedSpeciality = options.specialities.firstOrNull {
                it is SelectOption.Item && it.value == filters.speciality
            } ?: SelectOption.All,
            selectedRarity = options.rarities.firstOrNull {
                it is SelectOption.Item && it.value == filters.rarity
            } ?: SelectOption.All,
        )
    }

    init {
        selectedFilters.onEach(onFiltersChange).launchIn(scope)

        scope.launch {
            val factions = async { loadAllPages(factionRepository, PageSize(100)) }
            val attributes = async { loadAllPages(attributeRepository, PageSize(100)) }
            val specialities = async { loadAllPages(specialityRepository, PageSize(100)) }

            val factionOptions = listOf(SelectOption.All) + factions.await().map {
                SelectOption.Item(it.id, it.name, it.imageUri)
            }
            val attributesOptions = listOf(SelectOption.All) + attributes.await().map {
                SelectOption.Item(it.id, it.name, it.imageUri)
            }
            val specialityOptions = listOf(SelectOption.All) + specialities.await().map {
                SelectOption.Item(it.id, it.name, it.imageUri)
            }
            filterOptions.value = filterOptions.value.copy(
                factions = factionOptions,
                attributes = attributesOptions,
                specialities = specialityOptions
            )
        }
    }

    fun onIntent(intent: FilterIntent) {
        when (intent) {
            is FilterIntent.SetQuery ->
                if (selectedFilters.value.query != intent.query)
                    selectedFilters.value = selectedFilters.value.copy(query = intent.query)
            is FilterIntent.SetFaction ->
                if (selectedFilters.value.faction != intent.factionId)
                    selectedFilters.value = selectedFilters.value.copy(faction = intent.factionId)
            is FilterIntent.SetSpeciality ->
                if (selectedFilters.value.speciality != intent.specialityId)
                    selectedFilters.value = selectedFilters.value.copy(speciality = intent.specialityId)
            is FilterIntent.SetAttribute ->
                if (selectedFilters.value.attribute != intent.attributeId)
                    selectedFilters.value = selectedFilters.value.copy(attribute = intent.attributeId)
            is FilterIntent.SetRarity ->
                if (selectedFilters.value.rarity != intent.rarity)
                    selectedFilters.value = selectedFilters.value.copy(rarity = intent.rarity)
        }
    }
}
