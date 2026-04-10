package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.AttributeId
import org.zzzcompanion.features.characters.data.entities.Character
import org.zzzcompanion.features.characters.data.entities.CharacterId
import org.zzzcompanion.features.characters.data.entities.FactionId
import org.zzzcompanion.features.characters.data.entities.RarityId
import org.zzzcompanion.features.characters.data.entities.SpecialityId


class CharacterRepository {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters.asStateFlow()

    init {
        _characters.value = listOf(
            Character(
                CharacterId("1"),
                "Korin",
                FactionId("1"),
                AttributeId("1"),
                SpecialityId("1"),
                RarityId("1"),
                "https://sunderarmor.com/ZZZ/Character/thumb_corin.png"
            ),
            Character(
                CharacterId("2"),
                "Alice Thymefield",
                FactionId("2"),
                AttributeId("2"),
                SpecialityId("2"),
                RarityId("2"),
                "https://sunderarmor.com/ZZZ/Character/thumb_alice.png"
            )
        )
    }

    fun getAll(): List<Character> { return _characters.value }
    fun getById(id: CharacterId): Character? = _characters.value.firstOrNull { it.id == id }
}