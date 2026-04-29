package org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata

import kotlinx.coroutines.flow.Flow


interface CharacterUserDataDataSource {
    fun getAll(): Flow<List<CharacterUserDataLocalEntity>>
    fun getById(id: String) : CharacterUserDataLocalEntity?
    fun existsById(id: String): Boolean
    fun insert(character: CharacterUserDataLocalEntity)
}