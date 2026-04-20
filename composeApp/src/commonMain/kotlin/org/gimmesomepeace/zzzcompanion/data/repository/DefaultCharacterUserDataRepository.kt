package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata.FakeCharacterUserDataLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata.toDomain
import org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata.toLocalEntity


class DefaultCharacterUserDataRepository(
    private val characterUserDataLocalDataSource: FakeCharacterUserDataLocalDataSource
): CharacterUserDataRepository {
    override fun getAll(): Flow<List<CharacterUserData>> {
        return characterUserDataLocalDataSource.getAll().map { it.toDomain() }
    }

    override fun getByCharacterId(characterId: CharacterId): CharacterUserData? {
        return characterUserDataLocalDataSource.getByCharacterId(characterId.value)?.toDomain()
    }

    override fun addIfNotExistsByCharacterId(characterUserData: CharacterUserData) : Boolean {
        if (characterUserDataLocalDataSource.getByCharacterId(characterUserData.characterId.value) == null) {
            characterUserDataLocalDataSource.insert(characterUserData.toLocalEntity())
            return true
        }
        return false
    }
}