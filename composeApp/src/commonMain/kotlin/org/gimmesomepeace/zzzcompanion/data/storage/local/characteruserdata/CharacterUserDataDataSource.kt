package org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata

import kotlinx.coroutines.flow.Flow


interface CharacterUserDataDataSource {
    fun getAll(): Flow<List<CharacterUserDataLocalEntity>>
    fun getByCharacterId(characterId: String) : CharacterUserDataLocalEntity?
    fun existsByCharacterId(characterId: String): Boolean
    fun insert(character: CharacterUserDataLocalEntity)
}