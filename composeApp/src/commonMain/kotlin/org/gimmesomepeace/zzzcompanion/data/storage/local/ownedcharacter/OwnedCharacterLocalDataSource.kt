package org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter

import kotlinx.coroutines.flow.Flow


interface OwnedCharacterLocalDataSource {
    fun getAll(): Flow<List<OwnedCharacterLocalEntity>>
    fun getByCharacterId(characterId: String) : OwnedCharacterLocalEntity?
    fun existsByCharacterId(characterId: String): Boolean
    fun insert(character: OwnedCharacterLocalEntity)
}