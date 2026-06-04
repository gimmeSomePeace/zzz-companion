package me.gimmesomepeace.zzzcompanion.core.characteruserdata

import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.WriterRepository

interface CharacterUserDataRepository :
    ReaderRepository<CharacterUserData, CharacterId>,
    WriterRepository<CharacterUserData>
