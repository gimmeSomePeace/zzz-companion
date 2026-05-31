package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.WriterRepository

interface CharacterUserDataRepository:
    ReaderRepository<CharacterId, CharacterUserData>,
    WriterRepository<CharacterUserData>
