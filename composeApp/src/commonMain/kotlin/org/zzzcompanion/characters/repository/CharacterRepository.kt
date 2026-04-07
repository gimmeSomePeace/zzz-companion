package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.Character


object CharacterRepository {
    fun getCharacters(): List<Character> {
        val factions = FactionRepository.getAll()
        val attributes = AttributeRepository.getAll()
        val rarities = RarityRepository.getAll()
        val specialities = SpecialityRepository.getAll()

        return listOf(
            Character(
                1,
                "Korin",
                factions[0],
                attributes[0],
                specialities[0],
                rarities[0],
                "https://sunderarmor.com/ZZZ/Character/thumb_corin.png"
            ),
            Character(
                2,
                "Alice Thymefield",
                factions[1],
                attributes[1],
                specialities[1],
                rarities[1],
                "https://sunderarmor.com/ZZZ/Character/thumb_alice.png"
            )
        )
    }
}