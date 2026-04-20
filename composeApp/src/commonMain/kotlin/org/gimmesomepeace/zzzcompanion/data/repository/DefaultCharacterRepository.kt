package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.data.storage.local.character.CharacterLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.mapper.toListItem
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.features.browser.repository.CharacterRepository


class DefaultCharacterRepository(
    private val characterLocalDataSource: CharacterLocalDataSource,
) : CharacterRepository {

    override fun setOwned(
        characterId: CharacterId,
        owned: Boolean
    ) {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<List<CharacterListItem>> {
        return characterLocalDataSource.getAll().map { it.toListItem() }
    }

}