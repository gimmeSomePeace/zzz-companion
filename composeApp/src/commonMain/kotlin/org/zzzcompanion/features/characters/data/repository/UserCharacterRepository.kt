package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.UserCharacter


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
}
