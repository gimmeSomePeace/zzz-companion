package org.gimmesomepeace.zzzcompanion.presentation.component

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.domain.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.domain.usecase.GetCharacterContextsUseCase
import org.gimmesomepeace.zzzcompanion.presentation.filter.CharactersFilterController
import org.gimmesomepeace.zzzcompanion.presentation.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.presentation.filter.filterBy
import org.gimmesomepeace.zzzcompanion.presentation.filter.toUi
import org.gimmesomepeace.zzzcompanion.presentation.mapper.toUi


class CharactersStore(
    private val getCharacterContextsUseCase: GetCharacterContextsUseCase,
    private val referenceAggregator: ReferenceAggregator,
    private val filterController: CharactersFilterController,

    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase
) {
    val state: StateFlow<CharactersScreenState> = combine(
        getCharacterContextsUseCase.execute(),
        referenceAggregator.state,
        filterController.filters,
    ) { characters, refs, filters ->

        val characterItems = characters.filterBy(filters).toUi(
            factionById = refs.factionsById,
            specialitiesById = refs.specialitiesById,
            attributesById = refs.attributesById,
            raritiesById = refs.raritiesById
        )

        CharactersScreenState(
            characters = characterItems,
            factionOptions = listOf(null) + refs.factions,
            attributeOptions = listOf(null) + refs.attributes,
            specialityOptions = listOf(null) + refs.specialities,
            rarityOptions = listOf(null) + refs.rarities,
            filters = filters.toUi(
                factionsById = refs.factionsById,
                specialitiesById = refs.specialitiesById,
                raritiesById = refs.raritiesById,
                attributesById = refs.attributesById,
            )
        )
    }.stateIn(
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Default),
        SharingStarted.Eagerly,
        CharactersScreenState(
            filters = FiltersStateUi(),
            characters = emptyList(),
            factionOptions = emptyList(),
            attributeOptions = emptyList(),
            rarityOptions = emptyList(),
            specialityOptions = emptyList(),
        )
    )

    fun onIntent(intent: CharactersIntent) {
        when (intent) {
            is CharactersIntent.SetQuery -> filterController.updateQuery(intent.query)
            is CharactersIntent.SetFaction -> filterController.updateFactionId(intent.factionId)
            is CharactersIntent.SetAttribute -> filterController.updateAttributeId(intent.attributeId)
            is CharactersIntent.SetSpeciality -> filterController.updateSpecialityId(intent.specialityId)
            is CharactersIntent.SetRarity -> filterController.updateRarityId(intent.rarityId)
            is CharactersIntent.AddCharacter -> {
                if (!addCharacterToOwnedUseCase.execute(intent.characterId)) {
                    error("Cannot add character ${intent.characterId}")
                }
            }
        }
    }
}