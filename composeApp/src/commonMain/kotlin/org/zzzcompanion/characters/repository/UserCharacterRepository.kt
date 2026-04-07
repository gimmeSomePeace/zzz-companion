package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.UserCharacter
import org.zzzcompanion.characters.model.Character


object UserCharacterRepository {
    private var userCharacters: List<UserCharacter> = listOf(
        UserCharacter(CharacterRepository.getCharacters()[0])
    )

    fun getAll(): List<UserCharacter> {
        return userCharacters
    }

    fun add(character: Character) {
        if (userCharacters.any {it.character.id == character.id}) return
        val newUserCharacter = UserCharacter(character)
        userCharacters = userCharacters.plus(newUserCharacter)
    }
}
