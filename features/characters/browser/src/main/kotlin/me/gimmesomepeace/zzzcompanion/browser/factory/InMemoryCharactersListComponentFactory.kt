package me.gimmesomepeace.zzzcompanion.browser.factory

import com.arkivanov.decompose.ComponentContext
import me.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks
import me.gimmesomepeace.zzzcompanion.core.faction.Faction
import me.gimmesomepeace.zzzcompanion.core.character.Character
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import me.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import me.gimmesomepeace.zzzcompanion.data.memory.attribute.InMemoryAttributeRepository
import me.gimmesomepeace.zzzcompanion.data.memory.character.InMemoryCharacterRepository
import me.gimmesomepeace.zzzcompanion.data.memory.characteruserdata.InMemoryCharacterUserDataRepository
import me.gimmesomepeace.zzzcompanion.data.memory.faction.InMemoryFactionRepository
import me.gimmesomepeace.zzzcompanion.data.memory.speciality.InMemorySpecialityRepository
import me.gimmesomepeace.zzzcompanion.data.shared.storage.InMemoryListStorage
import me.gimmesomepeace.zzzcompanion.browser.CharactersBrowserComponent
import me.gimmesomepeace.zzzcompanion.filters.FilterComponent
import me.gimmesomepeace.zzzcompanion.browser.usecase.AddCharacterToOwnedUseCase
import me.gimmesomepeace.zzzcompanion.browser.usecase.GetCharactersPageUseCase
import java.net.URI
import java.util.UUID

class InMemoryCharactersListComponentFactory : CharactersListComponentFactory {
    override fun createComponent(
        componentContext: ComponentContext,
        goToCharacterDetails: (CharacterId) -> Unit,
    ): CharactersBrowserComponent {

        val factionRepository = getFactionRepository()
        val attributesRepository = getAttributesRepository()
        val specialitiesRepository = getSpecialitiesRepository()
        val characterRepository = getCharacterRepository()
        val characterUserDataRepository = getCharacterUserDataRepository()

        val addCharacterToOwnedUseCase = AddCharacterToOwnedUseCase(characterUserDataRepository)
        val getCharactersPageUseCase = GetCharactersPageUseCase(
            specialityRepository = specialitiesRepository,
            factionRepository = factionRepository,
            attributeRepository = attributesRepository,
            characterRepository = characterRepository,

            characterUserDataRepository = characterUserDataRepository,
        )

        return CharactersBrowserComponent(
            componentContext = componentContext,
            getCharactersPageUseCase = getCharactersPageUseCase,
            addCharacterToOwnedUseCase = addCharacterToOwnedUseCase,
            pageSize = PageSize(10),
            goToCharacterDetails = goToCharacterDetails,

            createFilterComponent = {scope, onFiltersChanged ->
                FilterComponent(
                    attributeRepository = attributesRepository,
                    specialityRepository = specialitiesRepository,
                    factionRepository = factionRepository,

                    scope = scope,
                    onFiltersChanged = onFiltersChanged,
                )
            },
        )
    }

    private fun getSpecialitiesRepository(): InMemorySpecialityRepository {
        val specialities = listOf(
            Speciality.create(
                SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
                "Anomaly",
                URI(
                    "https://static.wikia.nocookie.net/" +
                            "zenless-zone-zero/images/d/d2/Icon_Anomaly.png/" +
                            "revision/latest/scale-to-width-down/32?cb=20240704113735"
                )
            ),
            Speciality.create(
                SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
                "Support",
                URI(
                    "https://static.wikia.nocookie.net/" +
                            "zenless-zone-zero/images/2/2f/Icon_Support.png/" +
                            "revision/latest/scale-to-width-down/32?cb=20240704113754"
                )
            )
        )

        val storage = InMemoryListStorage(
            initialItems = specialities,
            idSelector = { it.id }
        )
        return InMemorySpecialityRepository(
            storage = storage,
        )
    }

    private fun getFactionRepository(): InMemoryFactionRepository {
        val factions = listOf(
            Faction.create(
                FactionId(UUID.fromString("f0a2b3ed-beda-4975-aa25-d9c1146ade00")),
                "Victoria Housekeeping Co.",
                URI(
                    "https://static.wikia.nocookie.net/" +
                            "zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/" +
                            "revision/latest?cb=20240915104752"
                )
            ),
            Faction.create(
                FactionId(UUID.fromString("021583e1-1f01-488a-a842-bb2195e4cd6e")),
                "Spook Shack",
                URI(
                    "https://static.wikia.nocookie.net/" +
                            "zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/" +
                            "revision/latest?cb=20250608103142"
                )
            )
        )

        val storage = InMemoryListStorage(
            initialItems = factions,
            idSelector = { it.id }
        )
        return InMemoryFactionRepository(
            storage = storage
        )
    }

    private fun getCharacterUserDataRepository(): InMemoryCharacterUserDataRepository {
        val characterUserData = listOf(
            CharacterUserData.create(
                CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
                EquippedDisks.create()
            )
        )

        val storage = InMemoryListStorage(
            initialItems = characterUserData,
            idSelector = { it.id },
        )
        return InMemoryCharacterUserDataRepository(storage = storage)
    }

    private fun getAttributesRepository(): InMemoryAttributeRepository {
        val attributes = listOf(
            Attribute.create(
                AttributeId(UUID.fromString("bd4779b3-36df-4280-81a8-59d77b8940ec")),
                "Physical",
                URI(
                    "https://static.wikia.nocookie.net/" +
                            "zenless-zone-zero/images/c/ce/Icon_Physical.png/" +
                            "revision/latest/scale-to-width-down/32?cb=20251231181902"
                )
            ),
            Attribute.create(
                AttributeId(UUID.fromString("59c71ade-975d-4cfd-b782-96560a5d6620")),
                "Ice",
                URI(
                    "https://static.wikia.nocookie.net/" +
                            "zenless-zone-zero/images/5/52/Icon_Ice.png/" +
                            "revision/latest/scale-to-width-down/32?cb=20251231181955"
                )
            )
        )

        val storage = InMemoryListStorage(
            initialItems = attributes,
            idSelector = { it.id }
        )
        return InMemoryAttributeRepository(storage = storage)
    }

    private fun getCharacterRepository(): InMemoryCharacterRepository {
        val characters = listOf(
            Character.create(
                CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
                "Korin",
                FactionId(UUID.fromString("f0a2b3ed-beda-4975-aa25-d9c1146ade00")),
                AttributeId(UUID.fromString("bd4779b3-36df-4280-81a8-59d77b8940ec")),
                SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
                Rarity.S,
                URI("https://sunderarmor.com/ZZZ/Character/thumb_corin.png")
            ),
            Character.create(
                CharacterId(UUID.fromString("c9faa28a-e555-4aa6-a219-6ac331644c0e")),
                "Alice Thymefield",
                FactionId(UUID.fromString("021583e1-1f01-488a-a842-bb2195e4cd6e")),
                AttributeId(UUID.fromString("59c71ade-975d-4cfd-b782-96560a5d6620")),
                SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
                Rarity.A,
                URI("https://sunderarmor.com/ZZZ/Character/thumb_alice.png")
            )
        )

        val storage = InMemoryListStorage(characters) {
            it.id
        }
        return InMemoryCharacterRepository(storage)
    }
}