package org.gimmesomepeace.zzzcompanion.data.characteruserdata.memory

import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository
import java.util.UUID


class InMemoryCharacterUserDataRepository :
    CharacterUserDataRepository {

    private var userInfo = listOf(
            CharacterUserData(
                CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc"))
            )
        )
    override fun getAll(): List<CharacterUserData> = userInfo

    override fun getById(id: CharacterId): CharacterUserData? = userInfo.find { it.id == id }

    override fun addIfNotExists(characterUserData: CharacterUserData) : Boolean {
        if (userInfo.any { it.id == characterUserData.id }) {
            return false
        }
        userInfo = userInfo.plus(characterUserData)
        return true
    }
}