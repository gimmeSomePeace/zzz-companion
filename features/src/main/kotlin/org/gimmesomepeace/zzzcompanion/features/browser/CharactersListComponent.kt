package org.gimmesomepeace.zzzcompanion.features.browser

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository
import org.gimmesomepeace.zzzcompanion.features.browser.filter.FilterComponent
import org.gimmesomepeace.zzzcompanion.features.browser.filter.SelectedFilters
import org.gimmesomepeace.zzzcompanion.features.browser.grid.GridComponent
import org.gimmesomepeace.zzzcompanion.features.browser.grid.GridEvent
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.GetCharactersPageUseCase

class CharactersListComponent internal constructor(
    private val componentContext: ComponentContext,
    private val getCharactersPageUseCase: GetCharactersPageUseCase,
    private val addCharacterToOwnedUseCase: AddCharacterToOwnedUseCase,
    private val pageSize: PageSize = PageSize(10),

    private val attributeRepository: AttributeReaderRepository,
    private val specialityRepository: SpecialityReaderRepository,
    private val factionRepository: FactionReaderRepository
) : ComponentContext by componentContext {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _characters: MutableStateFlow<List<CharacterListItem>> = MutableStateFlow(emptyList())
    private var cursor: String? = null

    internal val filterComponent = FilterComponent(
        attributeRepository = attributeRepository,
        specialityRepository = specialityRepository,
        factionRepository = factionRepository,
        scope = scope
    )

    internal val gridComponent = GridComponent(
        items = _characters,
        scope = scope,
    )

    private fun handleGridEvent(event: GridEvent<CharacterListItem>) {
        when (event) {
            is GridEvent.ItemClickedEvent -> onCharacterClicked(event.item)
        }
    }

    private fun onCharacterClicked(character: CharacterListItem) {
        if (!character.isOwned) scope.launch {
            addCharacterToOwnedUseCase.invoke(character.id)
            updatePage()
        }
        else println("Character $character")
    }

    init {
        lifecycle.doOnDestroy {
            scope.cancel()
        }

        filterComponent.selectedFilters
            .onEach(::updatePage)
            .launchIn(scope)

        gridComponent.events
            .onEach(::handleGridEvent)
            .launchIn(scope)
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
}
