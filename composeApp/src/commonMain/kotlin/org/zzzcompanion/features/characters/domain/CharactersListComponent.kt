package org.zzzcompanion.features.characters.domain

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.zzzcompanion.core.utils.componentCoroutineScope
import org.zzzcompanion.features.characters.data.entities.AttributeId
import org.zzzcompanion.features.characters.data.entities.FactionId
import org.zzzcompanion.features.characters.data.entities.RarityId
import org.zzzcompanion.features.characters.data.entities.SpecialityId
import org.zzzcompanion.features.characters.data.repository.ReferenceData
import org.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.zzzcompanion.features.characters.data.uiModels.CharactersScreenState
import org.zzzcompanion.features.characters.mappers.CharacterUiMapper
import org.zzzcompanion.features.characters.ui.CharacterUi
import org.zzzcompanion.features.characters.ui.CharactersAction


class CharactersListComponent (
    private val userCharacterRepository: UserCharacterRepository,
    private val referenceData: StateFlow<ReferenceData>,
    private val mapper: CharacterUiMapper,
    private val componentContext: ComponentContext,
    private val actionHandler: CharactersActionHandler

) : ComponentContext by componentContext {

    private val scope = componentContext.componentCoroutineScope()

    private var _filters = MutableStateFlow(CharactersFilters())
    val filters: StateFlow<CharactersFilters> = _filters.asStateFlow()


    val uiState: StateFlow<CharactersScreenState> = combine(
        userCharacterRepository.userCharacters,
        referenceData,
        filters
    ) { userCharacters, refs, f ->

        val userCharsIds = userCharacters.map { it.characterId }.toSet()

        val ownedUi = userCharacters.asSequence()
            .filter { uc ->
                val char = refs.characters.find { it.id == uc.characterId } ?: return@filter false
                filters.value.isOk(char)
            }
            .map { mapper.mapToUserCharacterDetails(it) }
            .toList()

        val missingUi = refs.characters.asSequence()
            .filter { it.id !in userCharsIds && filters.value.isOk(it) }
            .map { mapper.mapToCharacterDetails(it) }
            .toList()

        val characterItems = buildList {
            addAll(ownedUi.map { CharacterUi.Owned(it) })
            addAll(missingUi.map { CharacterUi.Missing(it) })
        }

        CharactersScreenState.Content(characterItems = characterItems, factionOptions = listOf(null) + refs.factions, attributeOptions = listOf(null) + refs.attributes, specialityOptions = listOf(null) + refs.specialities, rarityOptions = listOf(null) + refs.rarities, filters = mapper.mapToFilterDetails(f))
    }.stateIn(scope, SharingStarted.Lazily, CharactersScreenState.Loading(mapper.mapToFilterDetails(filters.value), emptyList(), emptyList(), emptyList(), emptyList()))

    fun onAction(action: CharactersAction) {
        actionHandler.handle(action)
    }

    fun onSearchQueryChanged(newQuery: String) { _filters.value = filters.value.copy(query = newQuery) }
    fun onFactionChanged(newFactionId: FactionId?) { _filters.value = filters.value.copy(factionId = newFactionId) }
    fun onAttributeChanged(newAttributeId: AttributeId?) { _filters.value = filters.value.copy(attributeId = newAttributeId) }
    fun onRarityChanged(newRarityId: RarityId?) { _filters.value = filters.value.copy(rarityId = newRarityId) }
    fun onSpecialityChanged(newSpecialityId: SpecialityId?) { _filters.value = filters.value.copy(specialityId = newSpecialityId) }
}
