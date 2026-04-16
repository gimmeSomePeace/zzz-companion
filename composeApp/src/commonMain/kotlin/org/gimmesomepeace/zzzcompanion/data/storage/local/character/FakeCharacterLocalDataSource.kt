package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FakeCharacterLocalDataSource : CharacterLocalDataSource {
    private val characters = MutableStateFlow(
        listOf(
            CharacterLocalEntity(
                "1",
                "Korin",
                "1",
                "1",
                "1",
                "1",
                "https://sunderarmor.com/ZZZ/Character/thumb_corin.png"
            ),
            CharacterLocalEntity(
                "2",
                "Alice Thymefield",
                "2",
                "2",
                "2",
                "2",
                "https://sunderarmor.com/ZZZ/Character/thumb_alice.png"
            )
        )
    )

    override fun getAll(): Flow<List<CharacterLocalEntity>> {
        return characters.asStateFlow()
    }
}