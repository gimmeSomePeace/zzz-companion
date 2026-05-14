package org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.util.UUID

class InMemoryCharacterUserDataRepository : CharacterUserDataRepository {

    private var userInfo = listOf(
        CharacterUserData.create(
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
            EquippedDisks()
        )
    )

    private companion object {
        const val MAX_BATCH_SIZE = 100
    }

    override fun getByPage(
        cursor: String?,
        pageSize: PageSize
    ): Page<CharacterUserData> {
        require(pageSize.value <= MAX_BATCH_SIZE) {
            "Page size must be between 0 and $MAX_BATCH_SIZE"
        }

        return userInfo.paginate(
            cursor,
            pageSize
        ) {
            it.id.value.toString()
        }
    }

    override fun getById(id: CharacterId): CharacterUserData? = userInfo.find { it.id == id }

    override fun getByIds(ids: List<CharacterId>): Map<CharacterId, CharacterUserData> {
        require(ids.size <= MAX_BATCH_SIZE) {
            "IDs size must be less or equal $MAX_BATCH_SIZE"
        }

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