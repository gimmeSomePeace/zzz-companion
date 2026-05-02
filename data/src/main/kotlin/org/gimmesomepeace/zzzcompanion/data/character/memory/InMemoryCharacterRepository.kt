package org.gimmesomepeace.zzzcompanion.data.character.memory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.gimmesomepeace.zzzcompanion.core.model.characters.Character
import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterRepository
import java.net.URI
import java.util.UUID


class InMemoryCharacterRepository : CharacterRepository {
    private val characters = MutableStateFlow(
        listOf(
            Character(
                CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
                "Korin",
                FactionId(UUID.fromString("f0a2b3ed-beda-4975-aa25-d9c1146ade00")),
                AttributeId(UUID.fromString("bd4779b3-36df-4280-81a8-59d77b8940ec")),
                SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
                RarityId(UUID.fromString("d0833aa8-0b65-4668-a8ca-27492be44817")),
                URI("https://sunderarmor.com/ZZZ/Character/thumb_corin.png")
            ),
            Character(
                CharacterId(UUID.fromString("c9faa28a-e555-4aa6-a219-6ac331644c0e")),
                "Alice Thymefield",
                FactionId(UUID.fromString("021583e1-1f01-488a-a842-bb2195e4cd6e")),
                AttributeId(UUID.fromString("59c71ade-975d-4cfd-b782-96560a5d6620")),
                SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
                RarityId(UUID.fromString("c6d33de6-aa82-4fc1-aa2f-bee21b442cf3")),
                URI("https://sunderarmor.com/ZZZ/Character/thumb_alice.png")
            )
        )
    )

    override fun getAll(): Flow<List<Character>> {
        return characters
    }
}