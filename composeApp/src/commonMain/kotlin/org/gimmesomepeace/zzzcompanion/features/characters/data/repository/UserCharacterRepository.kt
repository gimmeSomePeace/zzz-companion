package org.gimmesomepeace.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacter
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId
import java.util.UUID


class UserCharacterRepository {
    private var _userCharacters = MutableStateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacter>>(emptyList())
    val userCharacters = _userCharacters.asStateFlow()

    init {
        _userCharacters.value = listOf(
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacter(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId("1"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId("1")
            )
        )
    }

    private fun generateId(): org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId {
        return _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId(
            UUID.randomUUID().toString()
        )
    }

    fun getAll(): List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacter> { return _userCharacters.value }
    fun getById(id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId): org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacter? = _userCharacters.value.firstOrNull { it.id == id }

    fun add(characterId: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId): Boolean {
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
