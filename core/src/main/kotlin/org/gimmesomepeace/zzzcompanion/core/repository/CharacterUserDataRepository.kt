package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId


interface CharacterUserDataRepository {
    fun getAll(): Flow<List<org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData>>
    fun getById(id: org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId): org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData?
    fun addIfNotExists(characterUserData: org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData): Boolean
}