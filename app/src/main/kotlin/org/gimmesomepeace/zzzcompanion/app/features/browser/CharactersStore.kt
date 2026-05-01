package org.gimmesomepeace.zzzcompanion.app.features.browser

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersState
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.filterBy
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.toUi
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItemUi
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.app.features.browser.toUi
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharacterContextsUseCase

class CharactersStore(
    private val getCharacterContextsUseCase: org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharacterContextsUseCase,
    private val referenceAggregator: org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator.ReferenceAggregator,
    private val addCharacterToOwnedUseCase: org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
) {
    private val _filters: MutableStateFlow<org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersState> = MutableStateFlow(
        _root_ide_package_.org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersState()
    )
    private val _characters = getCharacterContextsUseCase.execute()
    private val _refs = referenceAggregator.state

    val state: StateFlow<org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState> = combine(
        _characters,
        _refs,
        _filters
    ) { characters, refs, filters ->

        // TODO(#16): добавить анимацию загрузки списка персонажей. Сейчас отображается пустой список
        var characterItems: List<org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItemUi> = emptyList()
        if (!refs.factions.isEmpty()) {
            characterItems = characters.filterBy(filters).toUi(
                factionById = refs.factionsById,
                specialitiesById = refs.specialitiesById,
                attributesById = refs.attributesById,
                raritiesById = refs.raritiesById
            )
        }

        _root_ide_package_.org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState(
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
        _root_ide_package_.org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState(
            filters = _root_ide_package_.org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersStateUi(),
            characters = emptyList(),
            factionOptions = emptyList(),
            attributeOptions = emptyList(),
            rarityOptions = emptyList(),
            specialityOptions = emptyList(),
        )
    )

    fun onIntent(intent: org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent) {
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