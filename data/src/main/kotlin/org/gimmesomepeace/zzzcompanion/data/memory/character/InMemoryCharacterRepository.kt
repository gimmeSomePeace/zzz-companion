package org.gimmesomepeace.zzzcompanion.data.memory.character

import org.gimmesomepeace.zzzcompanion.core.character.Character
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterWriterRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.data.memory.InMemoryRepository

private const val MAX_PAGE_SIZE = 100

class InMemoryCharacterRepository :
    InMemoryRepository<CharacterId, Character, CharacterFilters>({it.id}, Character::class, PageSize(MAX_PAGE_SIZE)),
    CharacterReaderRepository,
    CharacterWriterRepository
{
}
