package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId

enum class AddCharacterUserDataResult {
    ADDED,
    ALREADY_EXISTS
}


interface CharacterUserDataRepository {
    fun getAll(): List<CharacterUserData>
    fun getById(id: CharacterId): CharacterUserData?
    fun addIfNotExists(characterUserData: CharacterUserData): AddCharacterUserDataResult
}