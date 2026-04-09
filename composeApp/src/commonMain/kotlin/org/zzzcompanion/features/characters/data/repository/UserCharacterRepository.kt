package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.UserCharacter


class UserCharacterRepository {
    private var _userCharacters = MutableStateFlow<List<UserCharacter>>(emptyList())
    val userCharacters = _userCharacters.asStateFlow()

    init {
        _userCharacters.value = listOf(
            UserCharacter(1, 1)
        )
    }

    fun getAll(): List<UserCharacter> { return _userCharacters.value }
    fun getById(id: Long): UserCharacter? = _userCharacters.value.firstOrNull { it.id == id }
}
