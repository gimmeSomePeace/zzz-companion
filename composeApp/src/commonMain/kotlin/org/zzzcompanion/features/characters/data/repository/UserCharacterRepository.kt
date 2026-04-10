package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.CharacterId
import org.zzzcompanion.features.characters.data.entities.UserCharacter
import org.zzzcompanion.features.characters.data.entities.UserCharacterId
import java.util.UUID


class UserCharacterRepository {
    private var _userCharacters = MutableStateFlow<List<UserCharacter>>(emptyList())
    val userCharacters = _userCharacters.asStateFlow()

    init {
        _userCharacters.value = listOf(
            UserCharacter(UserCharacterId("1"), CharacterId("1"))
        )
    }

    private fun generateId(): UserCharacterId {
        return UserCharacterId(UUID.randomUUID().toString())
    }

    fun getAll(): List<UserCharacter> { return _userCharacters.value }
    fun getById(id: UserCharacterId): UserCharacter? = _userCharacters.value.firstOrNull { it.id == id }

    fun add(characterId: CharacterId): Boolean {
        if (_userCharacters.value.any { it.characterId == characterId }) {
            return false
        }

        _userCharacters.value += UserCharacter(
            id = generateId(),
            characterId = characterId
        )
        return true
    }

    fun remove(characterId: CharacterId): Boolean {
        val updated = _userCharacters.value.filterNot { it.characterId == characterId }

        return if (updated.size != _userCharacters.value.size) {
            _userCharacters.value = updated
            true
        } else false
    }
}
