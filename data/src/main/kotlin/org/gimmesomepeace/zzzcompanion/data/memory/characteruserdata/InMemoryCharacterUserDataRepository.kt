package org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataFilters
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.data.memory.InMemoryRepository

class InMemoryCharacterUserDataRepository :
    InMemoryRepository<CharacterId, CharacterUserData, CharacterUserDataFilters>({ it.id }, CharacterUserData::class, PageSize(100)),
    CharacterUserDataRepository
