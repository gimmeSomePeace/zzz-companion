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
import org.zzzcompanion.features.characters.data.repository.AttributeRepository
import org.zzzcompanion.features.characters.data.repository.CharacterRepository
import org.zzzcompanion.features.characters.data.repository.FactionRepository
import org.zzzcompanion.features.characters.data.repository.RarityRepository
import org.zzzcompanion.features.characters.data.repository.SpecialityRepository
import org.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.zzzcompanion.features.characters.data.uiModels.CharactersScreenState
import org.zzzcompanion.features.characters.mappers.CharacterUiMapper

class CharactersListComponent (
    private val userCharacterRepository: UserCharacterRepository,
    private val characterRepository: CharacterRepository,
    private val factionRepository: FactionRepository,
    private val attributeRepository: AttributeRepository,
    private val specialityRepository: SpecialityRepository,
    private val rarityRepository: RarityRepository,

    private val mapper: CharacterUiMapper,
    private val componentContext: ComponentContext,
) : ComponentContext by componentContext {

    private val scope = componentContext.componentCoroutineScope()
    var filters by mutableStateOf(CharactersFilters())
        private set

    val uiState: StateFlow<CharactersScreenState> = combine(
        userCharacterRepository.userCharacters,
        snapshotFlow { filters }
    ) { userCharsList, f ->
        val userCharsIds = userCharsList.map { it.id }.toSet()
        val allCharacters = characterRepository.getAll()

        val owned = userCharsList.map { mapper.mapToUserCharacterDetails(it) }
        val missing = allCharacters.filter { it.id !in userCharsIds }.map { mapper.mapToCharacterDetails(it) }

        val ownedFiltered = owned.filter { filters.isOk(it) }
        val missingFiltered = missing.filter { filters.isOk(it) }

        CharactersScreenState.Content(
            owned = ownedFiltered,
            missing = missingFiltered,

            factionOptions = listOf(null) + factionRepository.getAll(),
            attributeOptions = listOf(null) + attributeRepository.getAll(),
            specialityOptions = listOf(null) + specialityRepository.getAll(),
            rarityOptions = listOf(null) + rarityRepository.getAll(),
            filters = mapper.mapToFilterDetails(f)
        )
    }.stateIn(scope, SharingStarted.Companion.Lazily, CharactersScreenState.Loading(mapper.mapToFilterDetails(filters), emptyList(), emptyList(), emptyList(), emptyList()))

    fun onSearchQueryChanged(newQuery: String) { filters = filters.copy(query = newQuery) }
    fun onFactionChanged(newFactionId: Long?) { filters = filters.copy(factionId = newFactionId) }
    fun onAttributeChanged(newAttributeId: Long?) { filters = filters.copy(attributeId = newAttributeId) }
    fun onRarityChanged(newRarityId: Long?) { filters = filters.copy(rarityId = newRarityId) }
    fun onSpecialityChanged(newSpecialityId: Long?) { filters = filters.copy(specialityId = newSpecialityId) }
}