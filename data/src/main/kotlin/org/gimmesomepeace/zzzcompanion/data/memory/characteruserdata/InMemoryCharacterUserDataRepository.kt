package org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import java.util.UUID

class InMemoryCharacterUserDataRepository : CharacterUserDataRepository {

    private var userInfo = listOf(
        CharacterUserData(
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc"))
        )
    )

    override fun getAll(): List<CharacterUserData> = userInfo

    override fun getById(id: CharacterId): CharacterUserData? = userInfo.find { it.id == id }

    override fun getByIds(ids: List<CharacterId>): Map<CharacterId, CharacterUserData> {
        return userInfo
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override fun addIfNotExists(characterUserData: CharacterUserData) : AddCharacterUserDataResult {
        if (userInfo.any { it.id == characterUserData.id }) {
            return AddCharacterUserDataResult.ALREADY_EXISTS
        }
        userInfo = userInfo.plus(characterUserData)
        return AddCharacterUserDataResult.ADDED
    }
}