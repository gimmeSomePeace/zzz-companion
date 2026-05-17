package org.gimmesomepeace.zzzcompanion.app.features.browser.factory

import com.arkivanov.decompose.ComponentContext
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.ReferenceData
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharactersPageUseCase
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.data.memory.attribute.InMemoryAttributeRepository
import org.gimmesomepeace.zzzcompanion.data.memory.character.InMemoryCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata.InMemoryCharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.data.memory.faction.InMemoryFactionRepository
import org.gimmesomepeace.zzzcompanion.data.memory.speciality.InMemorySpecialityRepository

class InMemoryCharactersListComponentFactory : CharactersListComponentFactory {
    private fun <T> loadAllPages(loader: (String?) -> Page<T>): List<T> {
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

        val factions: List<Faction> = loadAllPages { cursor ->
            factionRepository.getPage(cursor)
        }
        val attributes: List<Attribute> = loadAllPages { cursor ->
            attributeRepository.getPage(cursor)
        }
        val specialities: List<Speciality> = loadAllPages { cursor ->
            specialityRepository.getPage(cursor)
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

        val charactersStore = CharactersStore(
            getCharactersPageUseCase = getCharactersPageUseCase,
            addCharacterToOwnedUseCase = addCharacterToOwnedUseCase,
            refs = refs
        )

        return CharactersListComponent(
            componentContext = componentContext,
            charactersStore = charactersStore,
        )
    }
}