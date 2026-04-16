package org.gimmesomepeace.zzzcompanion.presentation.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId
import org.gimmesomepeace.zzzcompanion.domain.usecase.GetCharacterContextsUseCase
import org.gimmesomepeace.zzzcompanion.presentation.filter.CharactersFilterController
import org.gimmesomepeace.zzzcompanion.presentation.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.presentation.filter.filterBy
import org.gimmesomepeace.zzzcompanion.presentation.filter.toUi
import org.gimmesomepeace.zzzcompanion.presentation.mapper.toUi
import org.gimmesomepeace.zzzcompanion.presentation.ui.character.CharactersAction


class CharactersListComponent (
    private val getCharacterContextsUseCase: GetCharacterContextsUseCase,

    private val referenceAggregator: ReferenceAggregator,
    private val componentContext: ComponentContext,
    private val actionHandler: CharactersActionHandler,
    private val filterController: CharactersFilterController
) : ComponentContext by componentContext {

    val uiState: StateFlow<CharactersScreenState> = combine(
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

    fun onAction(action: CharactersAction) {
        actionHandler.handle(action)
    }

    fun onSearchQueryChange(newQuery: String) { filterController.updateQuery(newQuery) }
    fun onFactionChange(newFactionId: FactionId?) { filterController.updateFactionId(newFactionId) }
    fun onAttributeChange(newAttributeId: AttributeId?) { filterController.updateAttributeId(newAttributeId) }
    fun onRarityChange(newRarityId: RarityId?) { filterController.updateRarityId(newRarityId) }
    fun onSpecialityChange(newSpecialityId: SpecialityId?) { filterController.updateSpecialityId(newSpecialityId) }
}