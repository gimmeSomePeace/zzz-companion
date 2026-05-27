package org.gimmesomepeace.zzzcompanion.features.browser.factory

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.runBlocking
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
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

class InMemoryCharactersListComponentFactory : CharactersListComponentFactory {
    private suspend fun <T> loadAllPages(loader: suspend (String?) -> Page<T>): List<T> {
        val result = mutableListOf<T>()
        var cursor: String? = null
        do {
            val page = loader(cursor)
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
            loadAllPages { cursor ->
                factionRepository.getPage(
                    PageSize(10), cursor, null)
            }
        }

        val attributes: List<Attribute> = runBlocking {
            loadAllPages { cursor ->
                attributeRepository.getPage(PageSize(10), cursor, null)
            }
        }

        val specialities: List<Speciality> = runBlocking {
            loadAllPages { cursor ->
                specialityRepository.getPage(PageSize(10), cursor, null)
            }
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