package me.gimmesomepeace.zzzcompanion.browser

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import me.gimmesomepeace.zzzcompanion.filters.FilterComponent
import me.gimmesomepeace.zzzcompanion.filters.model.SelectedFilters
import me.gimmesomepeace.zzzcompanion.catalog.CharactersCatalogIntent
import me.gimmesomepeace.zzzcompanion.catalog.CharactersCatalogState
import me.gimmesomepeace.zzzcompanion.browser.usecase.AddCharacterToOwnedUseCase
import me.gimmesomepeace.zzzcompanion.browser.usecase.GetCharactersPageUseCase
import me.gimmesomepeace.zzzcompanion.catalog.CharacterCatalogItem

class CharactersBrowserComponent internal constructor(
    private val componentContext: ComponentContext,
    private val getCharactersPageUseCase: GetCharactersPageUseCase,
    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase,
    private val pageSize: PageSize = PageSize(10),
    private val goToCharacterDetails: (CharacterId) -> Unit,

    createFilterComponent: (
        scope: CoroutineScope,
        onFiltersChanged: (SelectedFilters) -> Unit
    ) -> FilterComponent,
) : ComponentContext by componentContext {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _characters: MutableStateFlow<List<CharacterCatalogItem>> = MutableStateFlow(emptyList())
    private var cursor: String? = null

    internal val filterComponent = createFilterComponent(
        scope,
    ) { filters ->
        updatePage(filters)
    }

    internal val state = _characters.map {
        CharactersBrowserState(CharactersCatalogState(it))
    }.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = CharactersBrowserState(),
    )

    init {
        lifecycle.doOnDestroy {
            scope.cancel()
        }

        updatePage()
    }

    private fun updatePage(filters: SelectedFilters? = null) {
        scope.launch {
            val page = getCharactersPageUseCase(cursor, pageSize, CharacterFilters.create(
                query = filters?.query,
                factionId = filters?.faction,
                attributeId = filters?.attribute,
                specialityId = filters?.speciality,
                rarity = filters?.rarity
            ))

            _characters.value = page.items
            cursor = page.nextCursor
        }
    }

    fun onCharactersCatalogIntent(intent: CharactersCatalogIntent) {
        when (intent) {
            is CharactersCatalogIntent.GoToCharacterDetails -> goToCharacterDetails(intent.id)
            is CharactersCatalogIntent.AddCharacterToOwned -> scope.launch {
                addCharacterToOwnedUseCase(intent.id)
                _characters.value = _characters.value.map {
                    if (it.isOwned) it else it.copy(isOwned = true)
                }
            }
        }
    }
}
