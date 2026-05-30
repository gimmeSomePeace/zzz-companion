package org.gimmesomepeace.zzzcompanion.features.browser

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.uikit.select.selectedOrAll
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.features.browser.model.ReferenceData
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.GetCharactersPageUseCase

class CharactersListComponent internal constructor(
    private val componentContext: ComponentContext,
    private val getCharactersPageUseCase: GetCharactersPageUseCase,
    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase,
    private val refs: ReferenceData,
    private val pageSize: PageSize = PageSize(10),
) : ComponentContext by componentContext {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val _characters: MutableStateFlow<List<CharacterListItem>> = MutableStateFlow(emptyList())
    private var cursor: String? = null

    init {
        lifecycle.doOnDestroy {
            scope.cancel()
        }

        updatePage()
    }

    private fun updatePage() {
        scope.launch {
            val page = getCharactersPageUseCase(cursor, pageSize, _filters.value)

            _characters.value = page.items
            cursor = page.nextCursor
        }
    }

    internal val uiState: StateFlow<CharactersScreenState> = combine(
        _characters,
        _filters
    ) { characters, filters ->

        val characterItems = characters.map {
            it.toUi(
                factionById = refs.factionsById,
                specialitiesById = refs.specialitiesById,
                attributesById = refs.attributesById
            )
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
            SelectOption.Item(it, it.title, it.imageUri)
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
            selectedRarityOption = selectedRarityOption
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
            selectedSpecialityOption = SelectOption.All
        )
    )
}
