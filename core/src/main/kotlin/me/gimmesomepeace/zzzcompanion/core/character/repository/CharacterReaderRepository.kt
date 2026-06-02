package me.gimmesomepeace.zzzcompanion.core.character.repository

import me.gimmesomepeace.zzzcompanion.core.character.Character
import me.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface CharacterReaderRepository:
    ReaderRepository<Character, CharacterId>,
    PaginationRepository<Character, CharacterFilters>