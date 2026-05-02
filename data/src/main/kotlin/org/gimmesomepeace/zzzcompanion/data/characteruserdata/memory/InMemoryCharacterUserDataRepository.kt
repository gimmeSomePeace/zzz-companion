package org.gimmesomepeace.zzzcompanion.data.characteruserdata.memory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository
import java.util.UUID

class InMemoryCharacterUserDataRepository :
    CharacterUserDataRepository {

    private val userInfo = MutableStateFlow(
        listOf(
            CharacterUserData(
                CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc"))
            )
        )
    )
    override fun getAll(): Flow<List<CharacterUserData>> = userInfo

    override fun getById(id: CharacterId): CharacterUserData? = userInfo.value.find { it.id == id }

    override fun addIfNotExists(characterUserData: CharacterUserData) : Boolean {
        if (userInfo.value.any { it.id == characterUserData.id }) {
            return false
        }
        userInfo.value = userInfo.value.plus(characterUserData)
        return true
    }
}