package org.gimmesomepeace.zzzcompanion.core.character

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface CharacterRepository:
    ReaderRepository<Character, CharacterId>,
    PaginationRepository<Character, CharacterFilters>
