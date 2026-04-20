package org.gimmesomepeace.zzzcompanion.features.browser.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem


interface CharacterRepository {
    fun setOwned(characterId: CharacterId, owned: Boolean)
    fun getAll() : Flow<List<CharacterListItem>>
}
