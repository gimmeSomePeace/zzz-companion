package org.gimmesomepeace.zzzcompanion.features.characters.domain

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.core.utils.componentCoroutineScope
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.ReferenceData
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels.CharactersScreenState.Content
import org.gimmesomepeace.zzzcompanion.features.characters.mappers.toUi
import org.gimmesomepeace.zzzcompanion.features.characters.presentation.CharactersActionHandler
import org.gimmesomepeace.zzzcompanion.features.characters.presentation.CharactersFilterController
import org.gimmesomepeace.zzzcompanion.features.characters.presentation.CharactersPresenter
import org.gimmesomepeace.zzzcompanion.features.characters.ui.CharactersAction


class CharactersListComponent (
    private val userCharacterRepository: UserCharacterRepository,
    private val referenceData: StateFlow<ReferenceData>,
    private val componentContext: ComponentContext,
    private val actionHandler: CharactersActionHandler,
    private val filterController: CharactersFilterController,
    private val charactersPresenter: CharactersPresenter
) : ComponentContext by componentContext {

    private val scope = componentContext.componentCoroutineScope()

    val uiState: StateFlow<CharactersScreenState> = combine(
        userCharacterRepository.userCharacters,
        referenceData,
        filterController.filters,
    ) { userCharacters, refs, filters ->
        val characterItems = charactersPresenter.present(
            userCharacters = userCharacters,
            refs = refs,
            filters = filters,
        )

        Content(
            characterItems = characterItems,
            factionOptions = listOf(null) + refs.factions,
            attributeOptions = listOf(null) + refs.attributes,
            specialityOptions = listOf(null) + refs.specialities,
            rarityOptions = listOf(null) + refs.rarities,
            filters = filters.toUi(refs)
        )
    }.stateIn(scope, SharingStarted.Lazily, CharactersScreenState.Loading(filterController.filters.value.toUi(referenceData.value), emptyList(), emptyList(), emptyList(), emptyList()))

    fun onAction(action: CharactersAction) {
        // TODO: сделать проброс UI action в отдельный поток
        actionHandler.handle(action)
    }

    fun onSearchQueryChange(newQuery: String) { filterController.updateQuery(newQuery) }
    fun onFactionChange(newFactionId: FactionId?) { filterController.updateFactionId(newFactionId) }
    fun onAttributeChange(newAttributeId: AttributeId?) { filterController.updateAttributeId(newAttributeId) }
    fun onRarityChange(newRarityId: RarityId?) { filterController.updateRarityId(newRarityId) }
    fun onSpecialityChange(newSpecialityId: SpecialityId?) { filterController.updateSpecialityId(newSpecialityId) }
}
