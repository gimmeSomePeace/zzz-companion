package org.gimmesomepeace.zzzcompanion.features.browser.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.features.browser.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.features.browser.domain.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.domain.usecase.GetCharacterContextsUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.filter.FiltersState
import org.gimmesomepeace.zzzcompanion.features.browser.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.features.browser.filter.filterBy
import org.gimmesomepeace.zzzcompanion.features.browser.filter.toUi
import org.gimmesomepeace.zzzcompanion.features.browser.mapper.toUi
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.model.CharacterListItemUi
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.model.CharactersScreenState

class CharactersStore(
    private val getCharacterContextsUseCase: GetCharacterContextsUseCase,
    private val referenceAggregator: ReferenceAggregator,
    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase
) {
    private val _filters: MutableStateFlow<FiltersState> = MutableStateFlow(FiltersState())
    private val _characters = getCharacterContextsUseCase.execute()
    private val _refs = referenceAggregator.state

    val state: StateFlow<CharactersScreenState> = combine(
        _characters,
        _refs,
        _filters
    ) { characters, refs, filters ->

        // TODO: поменять на норм логику. Пока это просто заглушка
        var characterItems: List<CharacterListItemUi> = emptyList()
        if (!refs.factions.isEmpty()) {
            characterItems = characters.filterBy(filters).toUi(
                factionById = refs.factionsById,
                specialitiesById = refs.specialitiesById,
                attributesById = refs.attributesById,
                raritiesById = refs.raritiesById
            )
        }

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
            is CharactersIntent.SetQuery -> _filters.value = _filters.value.copy(query = intent.query)
            is CharactersIntent.SetFaction -> _filters.value = _filters.value.copy(factionId = intent.factionId)
            is CharactersIntent.SetAttribute -> _filters.value = _filters.value.copy(attributeId = intent.attributeId)
            is CharactersIntent.SetSpeciality -> _filters.value = _filters.value.copy(specialityId = intent.specialityId)
            is CharactersIntent.SetRarity -> _filters.value = _filters.value.copy(rarityId = intent.rarityId)
            is CharactersIntent.AddCharacter -> {
                addCharacterToOwnedUseCase.execute(intent.characterId)
            }
        }
    }
}