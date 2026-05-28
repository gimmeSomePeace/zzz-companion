package org.gimmesomepeace.zzzcompanion.core.character.repository

import org.gimmesomepeace.zzzcompanion.core.character.Character
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface CharacterReaderRepository:
    ReaderRepository<Character, CharacterId>,
    PaginationRepository<Character, CharacterFilters>