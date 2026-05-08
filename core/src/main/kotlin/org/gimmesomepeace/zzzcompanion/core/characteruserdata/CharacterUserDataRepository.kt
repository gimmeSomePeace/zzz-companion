package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize

enum class AddCharacterUserDataResult {
    ADDED,
    ALREADY_EXISTS
}

interface CharacterUserDataRepository {
    fun getByPage(cursor: String?, pageSize: PageSize): Page<CharacterUserData>

    fun getById(id: CharacterId): CharacterUserData?
    fun getByIds(ids: List<CharacterId>): Map<CharacterId, CharacterUserData>
    fun addIfNotExists(characterUserData: CharacterUserData): AddCharacterUserDataResult
}