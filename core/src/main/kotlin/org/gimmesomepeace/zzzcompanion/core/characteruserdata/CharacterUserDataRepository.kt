package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

enum class AddCharacterUserDataResult {
    ADDED,
    ALREADY_EXISTS,
}

interface CharacterUserDataRepository:
    ReaderRepository<CharacterUserData, CharacterId>
{
    fun addIfNotExists(characterUserData: CharacterUserData): AddCharacterUserDataResult
}
