package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.Character


class CharacterRepository {
    private val characters = listOf(
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

    fun getAll(): List<Character> {
        return characters
    }

    fun getById(id: Long): Character? = characters.firstOrNull { it.id == id }
}