package me.gimmesomepeace.zzzcompanion.filters

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.gimmesomepeace.uikit.select.SelectOption
import me.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import me.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import me.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository
import me.gimmesomepeace.zzzcompanion.filters.model.FiltersOptionsState
import me.gimmesomepeace.zzzcompanion.filters.model.FilterState
import me.gimmesomepeace.zzzcompanion.filters.model.SelectedFilters
import kotlin.collections.map

class FilterComponent(
    attributeRepository: AttributeReaderRepository,
    specialityRepository: SpecialityReaderRepository,
    factionRepository: FactionReaderRepository,
    scope: CoroutineScope,

    val onFiltersChanged: (SelectedFilters) -> Unit
) {
    private val selectedFilters = MutableStateFlow(SelectedFilters())
    private val filterOptions = MutableStateFlow(FiltersOptionsState())

    internal val state = combine(
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
    }.stateIn(
        scope = scope,
        started = SharingStarted.Eagerly,
        initialValue = FilterState()
    )

    init {
        selectedFilters.onEach { newFilters ->
            onFiltersChanged(newFilters)
        }.launchIn(scope)

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
            val rarityOptions = listOf(SelectOption.All) + Rarity.entries.map {
                SelectOption.Item(it, it.title, it.imageUri)
            }
            filterOptions.value = filterOptions.value.copy(
                factions = factionOptions,
                attributes = attributesOptions,
                specialities = specialityOptions,
                rarities = rarityOptions,
            )
        }
    }

    internal fun onIntent(intent: FiltersIntent) {
        when (intent) {
            is FiltersIntent.SetQuery ->
                if (selectedFilters.value.query != intent.query)
                    selectedFilters.value = selectedFilters.value.copy(query = intent.query)
            is FiltersIntent.SetFaction ->
                if (selectedFilters.value.faction != intent.factionId)
                    selectedFilters.value = selectedFilters.value.copy(faction = intent.factionId)
            is FiltersIntent.SetSpeciality ->
                if (selectedFilters.value.speciality != intent.specialityId)
                    selectedFilters.value = selectedFilters.value.copy(speciality = intent.specialityId)
            is FiltersIntent.SetAttribute ->
                if (selectedFilters.value.attribute != intent.attributeId)
                    selectedFilters.value = selectedFilters.value.copy(attribute = intent.attributeId)
            is FiltersIntent.SetRarity ->
                if (selectedFilters.value.rarity != intent.rarity)
                    selectedFilters.value = selectedFilters.value.copy(rarity = intent.rarity)
        }
    }
}
