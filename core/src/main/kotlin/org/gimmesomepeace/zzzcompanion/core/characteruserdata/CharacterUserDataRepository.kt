package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId

enum class AddCharacterUserDataResult {
    ADDED,
    ALREADY_EXISTS
}


interface CharacterUserDataRepository {
    fun getAll(): List<CharacterUserData>

    fun getById(id: CharacterId): CharacterUserData?
    fun getByIds(ids: List<CharacterId>): Map<CharacterId, CharacterUserData>
    fun addIfNotExists(characterUserData: CharacterUserData): AddCharacterUserDataResult
}