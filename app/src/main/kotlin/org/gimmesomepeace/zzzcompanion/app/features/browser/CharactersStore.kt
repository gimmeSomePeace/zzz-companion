package org.gimmesomepeace.zzzcompanion.app.features.browser

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator.ReferenceData
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.toUi
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharactersPageUseCase
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize
import kotlin.collections.emptyList

class CharactersStore(
    private val getCharactersPageUseCase: GetCharactersPageUseCase,
    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase,
    private val refs: ReferenceData,
    private val pageSize: PageSize = PageSize(10),
) {
    private val _filters: MutableStateFlow<CharacterFilters> = MutableStateFlow(
        CharacterFilters()
    )
    private val _characters: MutableStateFlow<List<CharacterListItem>> = MutableStateFlow(emptyList())
    private var cursor: String? = null

    init {
        updatePage()
    }

    private fun updatePage() {
        val page = getCharactersPageUseCase.execute(null, pageSize, _filters.value)
        _characters.value = page.items
        cursor = page.nextCursor
    }

    val state: StateFlow<CharactersScreenState> = combine(
        _characters,
        _filters
    ) { characters, filters ->

        // TODO(#16): добавить анимацию загрузки списка персонажей. Сейчас отображается пустой список
        val characterItems = characters.toUi(
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
            is CharactersIntent.SetQuery -> {
                if (_filters.value.query != intent.query) {
                    _filters.value = _filters.value.copy(query = intent.query)
                    cursor = null
                    updatePage()
                }
            }
            is CharactersIntent.SetFaction -> {
                if (_filters.value.factionId != intent.factionId) {
                    _filters.value = _filters.value.copy(factionId = intent.factionId)
                    cursor = null
                    updatePage()
                }
            }
            is CharactersIntent.SetAttribute -> {
                if (_filters.value.attributeId != intent.attributeId) {
                    _filters.value = _filters.value.copy(attributeId = intent.attributeId)
                    cursor = null
                    updatePage()
                }
            }
            is CharactersIntent.SetSpeciality -> {
                if (_filters.value.specialityId != intent.specialityId) {
                    _filters.value = _filters.value.copy(specialityId = intent.specialityId)
                    cursor = null
                    updatePage()
                }
            }
            is CharactersIntent.SetRarity -> {
                if (_filters.value.rarityId != intent.rarityId) {
                    _filters.value = _filters.value.copy(rarityId = intent.rarityId)
                    cursor = null
                    updatePage()
                }
            }
            is CharactersIntent.AddCharacter -> {
                val result = addCharacterToOwnedUseCase.execute(intent.characterId)
                if (result == AddCharacterUserDataResult.ADDED) {
                    _characters.value = _characters.value.map {
                        if (it.id == intent.characterId) it.copy(isOwned = true)
                        else it
                    }
                }
            }
        }
    }
}