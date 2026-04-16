package org.gimmesomepeace.zzzcompanion.domain.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.OwnedCharacter


interface OwnedCharacterRepository {
    fun getAll() : Flow<List<OwnedCharacter>>
    fun getByCharacterId(characterId: CharacterId) : OwnedCharacter?
    fun addIfNotExists(character: OwnedCharacter) : Boolean
}