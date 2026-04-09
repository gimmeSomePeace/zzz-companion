package org.zzzcompanion.characters.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.characters.model.UserCharacter


class UserCharacterRepository {
    private var _userCharacters = MutableStateFlow<List<UserCharacter>>(
        listOf(
            UserCharacter(1, 1)
        )
    )
    val userCharacters = _userCharacters.asStateFlow()

    fun getAll(): List<UserCharacter> {
        return _userCharacters.value
    }

    fun getById(id: Long): UserCharacter? {
        return _userCharacters.value.firstOrNull { it.id == id }
    }

//    fun add(character: Character) {
//        if (userCharacters.any {it.character.id == character.id}) return
//        val newUserCharacter = UserCharacter(character)
//        userCharacters = userCharacters.plus(newUserCharacter)
//    }
}
