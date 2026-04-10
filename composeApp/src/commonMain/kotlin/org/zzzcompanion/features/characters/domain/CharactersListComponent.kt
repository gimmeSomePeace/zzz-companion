package org.zzzcompanion.features.characters.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.zzzcompanion.core.utils.componentCoroutineScope
import org.zzzcompanion.features.characters.data.entities.AttributeId
import org.zzzcompanion.features.characters.data.entities.CharacterId
import org.zzzcompanion.features.characters.data.entities.FactionId
import org.zzzcompanion.features.characters.data.entities.RarityId
import org.zzzcompanion.features.characters.data.entities.SpecialityId
import org.zzzcompanion.features.characters.data.repository.ReferenceData
import org.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.zzzcompanion.features.characters.data.uiModels.CharactersScreenState
import org.zzzcompanion.features.characters.mappers.CharacterUiMapper
import org.zzzcompanion.features.characters.ui.CharacterUi


class CharactersListComponent (
    private val userCharacterRepository: UserCharacterRepository,
    private val referenceData: StateFlow<ReferenceData>,

    private val mapper: CharacterUiMapper,
    private val componentContext: ComponentContext,
) : ComponentContext by componentContext {

    private val scope = componentContext.componentCoroutineScope()
    var filters by mutableStateOf(CharactersFilters())
        private set

    val uiState: StateFlow<CharactersScreenState> = combine(
        userCharacterRepository.userCharacters,
        referenceData,
        snapshotFlow { filters }
    ) { userCharacters, refs, f ->

        val userCharsIds = userCharacters.map { it.characterId }.toSet()

        val ownedUi = userCharacters.asSequence()
            .filter { uc ->
                val char = refs.characters.find { it.id == uc.characterId } ?: return@filter false
                filters.isOk(char)
            }
            .map { mapper.mapToUserCharacterDetails(it) }
            .toList()

        val missingUi = refs.characters.asSequence()
            .filter { it.id !in userCharsIds && filters.isOk(it) }
            .map { mapper.mapToCharacterDetails(it) }
            .toList()

        val characterItems = buildList {
            addAll(ownedUi.map { CharacterUi.Owned(it) })
            addAll(missingUi.map { CharacterUi.Missing(it) })
        }

        CharactersScreenState.Content(
            characterItems = characterItems,

            factionOptions = listOf(null) + refs.factions,
            attributeOptions = listOf(null) + refs.attributes,
            specialityOptions = listOf(null) + refs.specialities,
            rarityOptions = listOf(null) + refs.rarities,
            filters = mapper.mapToFilterDetails(f)
        )
    }.stateIn(scope, SharingStarted.Lazily, CharactersScreenState.Loading(mapper.mapToFilterDetails(filters), emptyList(), emptyList(), emptyList(), emptyList()))

    fun onSearchQueryChanged(newQuery: String) { filters = filters.copy(query = newQuery) }
    fun onFactionChanged(newFactionId: FactionId?) { filters = filters.copy(factionId = newFactionId) }
    fun onAttributeChanged(newAttributeId: AttributeId?) { filters = filters.copy(attributeId = newAttributeId) }
    fun onRarityChanged(newRarityId: RarityId?) { filters = filters.copy(rarityId = newRarityId) }
    fun onSpecialityChanged(newSpecialityId: SpecialityId?) { filters = filters.copy(specialityId = newSpecialityId) }

    fun onAddCharacter(characterId: CharacterId) {
        userCharacterRepository.add(characterId)
    }
}
