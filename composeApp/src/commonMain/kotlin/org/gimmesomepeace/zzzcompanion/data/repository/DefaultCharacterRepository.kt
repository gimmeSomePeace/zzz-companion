package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.core.model.Character
import org.gimmesomepeace.zzzcompanion.data.storage.local.character.CharacterLocalDataSource
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterRepository
import org.gimmesomepeace.zzzcompanion.data.storage.local.character.toDomain


class DefaultCharacterRepository(
    private val characterLocalDataSource: CharacterLocalDataSource,
) : CharacterRepository {

    override fun getAll(): Flow<List<Character>> {
        return characterLocalDataSource.getAll().map { it.toDomain() }
    }

}