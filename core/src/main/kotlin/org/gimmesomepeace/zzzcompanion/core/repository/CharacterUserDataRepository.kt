package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId


interface CharacterUserDataRepository {
    fun getAll(): List<CharacterUserData>
    fun getById(id: CharacterId): CharacterUserData?
    fun addIfNotExists(characterUserData: CharacterUserData): Boolean
}