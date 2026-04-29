package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URI


class FakeCharacterLocalDataSource : CharacterLocalDataSource {
    private val characters = MutableStateFlow(
        listOf(
            CharacterLocalEntity(
                "0f902410-e39f-440b-a0ba-4c485d3039cc",
                "Korin",
                "f0a2b3ed-beda-4975-aa25-d9c1146ade00",
                "bd4779b3-36df-4280-81a8-59d77b8940ec",
                "c108d8ae-7a2a-4e65-a8ed-56a721cba262",
                "d0833aa8-0b65-4668-a8ca-27492be44817",
                URI("https://sunderarmor.com/ZZZ/Character/thumb_corin.png")
            ),
            CharacterLocalEntity(
                "c9faa28a-e555-4aa6-a219-6ac331644c0e",
                "Alice Thymefield",
                "021583e1-1f01-488a-a842-bb2195e4cd6e",
                "59c71ade-975d-4cfd-b782-96560a5d6620",
                "fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c",
                "c6d33de6-aa82-4fc1-aa2f-bee21b442cf3",
                URI("https://sunderarmor.com/ZZZ/Character/thumb_alice.png")
            )
        )
    )

    override fun getAll(): Flow<List<CharacterLocalEntity>> {
        return characters.asStateFlow()
    }
}