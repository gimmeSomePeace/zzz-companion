package org.gimmesomepeace.zzzcompanion.features.browser.factory

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.runBlocking
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.data.memory.attribute.InMemoryAttributeRepository
import org.gimmesomepeace.zzzcompanion.data.memory.character.InMemoryCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata.InMemoryCharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.data.memory.faction.InMemoryFactionRepository
import org.gimmesomepeace.zzzcompanion.data.memory.speciality.InMemorySpecialityRepository
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.browser.model.ReferenceData
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.GetCharactersPageUseCase

private const val DEFAULT_PAGE_SIZE = 100

class InMemoryCharactersListComponentFactory : CharactersListComponentFactory {
    private suspend fun <T, F> loadAllPages(
        repository: PaginationRepository<T, F>,
        pageSize: PageSize = PageSize(DEFAULT_PAGE_SIZE),
    ): List<T> {
        val result = mutableListOf<T>()
        var cursor: String? = null
        do {
            val page = repository.getPage(pageSize, cursor, null)
            result += page.items
            cursor = page.nextCursor
        } while (cursor != null)

        return result
    }

    override fun createComponent(componentContext: ComponentContext): CharactersListComponent {
        val characterRepository = InMemoryCharacterRepository()
        val factionRepository = InMemoryFactionRepository()
        val attributeRepository = InMemoryAttributeRepository()
        val specialityRepository = InMemorySpecialityRepository()
        val characterUserDataRepository = InMemoryCharacterUserDataRepository()

        val factions: List<Faction> = runBlocking {
            loadAllPages(factionRepository)
        }

        val attributes: List<Attribute> = runBlocking {
            loadAllPages(attributeRepository)
        }

        val specialities: List<Speciality> = runBlocking {
            loadAllPages(specialityRepository)
        }

        val refs = ReferenceData(
            factions = factions,
            attributes = attributes,
            specialities = specialities,

            factionsById = factions.associateBy { it.id },
            attributesById = attributes.associateBy { it.id },
            specialitiesById = specialities.associateBy { it.id }
        )

        val addCharacterToOwnedUseCase = AddCharacterToOwnedUseCase(characterUserDataRepository)
        val getCharactersPageUseCase = GetCharactersPageUseCase(characterRepository, characterUserDataRepository)

        return CharactersListComponent(
            componentContext = componentContext,
            getCharactersPageUseCase = getCharactersPageUseCase,
            addCharacterToOwnedUseCase = addCharacterToOwnedUseCase,
            refs = refs
        )
    }
}