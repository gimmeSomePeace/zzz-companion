package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter.OwnedCharacterLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter.toDomain
import org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter.toLocalEntity
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.OwnedCharacter
import org.gimmesomepeace.zzzcompanion.domain.repository.OwnedCharacterRepository


class DefaultOwnedCharacterRepository(
    private val localDataSource: OwnedCharacterLocalDataSource
) : OwnedCharacterRepository {
    override fun getAll(): Flow<List<OwnedCharacter>> {
        return localDataSource.getAll().map { it.toDomain() }
    }

    override fun getByCharacterId(characterId: CharacterId): OwnedCharacter? {
        return localDataSource.getByCharacterId(characterId.value)?.toDomain()
    }

    override fun addIfNotExists(character: OwnedCharacter) : Boolean {
        if (localDataSource.existsByCharacterId(character.characterId.value)) {
            return false
        }

        localDataSource.insert(character.toLocalEntity())
        return true
    }
}