package org.gimmesomepeace.zzzcompanion.features.browser.factory

import com.arkivanov.decompose.ComponentContext
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.character.Character
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.data.memory.character.InMemoryCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata.InMemoryCharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.data.shared.storage.InMemoryListStorage
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.browser.model.ReferenceData
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.GetCharactersPageUseCase
import java.net.URI
import java.util.UUID

class InMemoryCharactersListComponentFactory : CharactersListComponentFactory {

    override fun createComponent(componentContext: ComponentContext): CharactersListComponent {

        val characterRepository = getCharacterRepository()
        val characterUserDataRepository = getCharacterUserDataRepository()

        val factions = getFactions()
        val attributes = getAttributes()
        val specialities = getSpecialities()

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

    private fun getSpecialities(): List<Speciality> {
        return listOf(
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
    }

    private fun getFactions(): List<Faction> {
        return listOf(
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
    }

    private fun getCharacterUserData(): List<CharacterUserData> {
        return listOf(
            CharacterUserData.create(
                CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
                EquippedDisks.create()
            )
        )
    }

    private fun getCharacters(): List<Character> {
        return listOf(
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
    }

    private fun getAttributes(): List<Attribute> {
        return listOf(
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
    }

    private fun getCharacterRepository(): CharacterReaderRepository {
        val storage = InMemoryListStorage(getCharacters()) {
            it.id
        }
        return InMemoryCharacterRepository(storage)
    }

    private fun getCharacterUserDataRepository(): CharacterUserDataRepository {
        val storage = InMemoryListStorage(getCharacterUserData()) {
            it.id
        }
        return InMemoryCharacterUserDataRepository(storage)
    }
}