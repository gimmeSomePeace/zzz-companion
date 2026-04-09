package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.Character


class CharacterRepository {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters.asStateFlow()

    init {
        _characters.value = listOf(
            Character(
                1,
                "Korin",
                1,
                1,
                1,
                1,
                "https://sunderarmor.com/ZZZ/Character/thumb_corin.png"
            ),
            Character(
                2,
                "Alice Thymefield",
                2,
                2,
                2,
                2,
                "https://sunderarmor.com/ZZZ/Character/thumb_alice.png"
            )
        )
    }

    fun getAll(): List<Character> { return _characters.value }
    fun getById(id: Long): Character? = _characters.value.firstOrNull { it.id == id }
}