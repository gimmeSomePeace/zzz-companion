package org.gimmesomepeace.zzzcompanion.app.features.browser

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.ReferenceData
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharactersPageUseCase
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize
import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.uikit.select.selectedOrAll
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
        val page = getCharactersPageUseCase(null, pageSize, _filters.value)
        _characters.value = page.items
        cursor = page.nextCursor
    }

    val state: StateFlow<CharactersScreenState> = combine(
        _characters,
        _filters
    ) { characters, filters ->

        // TODO(#16): добавить анимацию загрузки списка персонажей. Сейчас отображается пустой список
        val characterItems = characters.map { it.toUi(
            factionById = refs.factionsById,
            specialitiesById = refs.specialitiesById,
            attributesById = refs.attributesById,
        )}

        val factionOptions = listOf(SelectOption.All) + refs.factions.map {
            SelectOption.Item(it.id, it.name, it.imageUri)
        }

        val selectedFactionOption = factionOptions.selectedOrAll(filters.factionId)

        val attributeOptions = listOf(SelectOption.All) + refs.attributes.map {
            SelectOption.Item(it.id, it.name, it.imageUri)
        }
        val selectedAttributeOption = attributeOptions.selectedOrAll(filters.attributeId)

        val specialityOptions = listOf(SelectOption.All) + refs.specialities.map {
            SelectOption.Item(it.id, it.name, it.imageUri)
        }
        val selectedSpecialityOption = specialityOptions.selectedOrAll(filters.specialityId)

        val rarityOptions = listOf(SelectOption.All) + Rarity.entries.map {
            SelectOption.Item(it, it.title, it.imageUrl)
        }
        val selectedRarityOption = rarityOptions.selectedOrAll(filters.rarity)

        CharactersScreenState(
            characters = characterItems,

            factionOptions = factionOptions,
            selectedFactionOption = selectedFactionOption,

            attributeOptions = attributeOptions,
            selectedAttributeOption = selectedAttributeOption,

            specialityOptions = specialityOptions,
            selectedSpecialityOption = selectedSpecialityOption,

            rarityOptions = rarityOptions,
            selectedRarityOption = selectedRarityOption,
        )
    }.stateIn(
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Default),
        SharingStarted.Eagerly,
        CharactersScreenState(
            characters = emptyList(),
            factionOptions = emptyList(),
            attributeOptions = emptyList(),
            rarityOptions = emptyList(),
            specialityOptions = emptyList(),
            selectedFactionOption = SelectOption.All,
            selectedAttributeOption = SelectOption.All,
            selectedRarityOption = SelectOption.All,
            selectedSpecialityOption = SelectOption.All,
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
                if (_filters.value.rarity != intent.rarity) {
                    _filters.value = _filters.value.copy(rarity = intent.rarity)
                    cursor = null
                    updatePage()
                }
            }
            is CharactersIntent.AddCharacter -> {
                val result = addCharacterToOwnedUseCase(intent.characterId)
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