package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId


interface CharacterUserDataRepository {
    fun getAll(): Flow<List<CharacterUserData>>
    fun getById(id: CharacterId): CharacterUserData?
    fun addIfNotExists(characterUserData: CharacterUserData): Boolean
}