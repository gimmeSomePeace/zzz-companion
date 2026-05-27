package org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import java.util.UUID

class InMemoryCharacterUserDataRepository : CharacterUserDataRepository {

    private var userInfo = listOf(
        CharacterUserData.create(
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
            EquippedDisks.create()
        )
    )

    private companion object {
        const val MAX_BATCH_SIZE = 100
    }

//    override fun getByPage(cursor: String?, pageSize: PageSize): Page<CharacterUserData> {
//        require(pageSize.value <= MAX_BATCH_SIZE) {
//            "Page size must be between 0 and $MAX_BATCH_SIZE"
//        }
//
//        return userInfo.paginate(
//            cursor,
//            pageSize
//        ) {
//            it.id.value.toString()
//        }
//    }

    override fun addIfNotExists(characterUserData: CharacterUserData): AddCharacterUserDataResult =
        if (userInfo.any { it.id == characterUserData.id }) {
            AddCharacterUserDataResult.ALREADY_EXISTS
        }
        else {
            userInfo = userInfo.plus(characterUserData)
            AddCharacterUserDataResult.ADDED
        }

    override suspend fun get(id: CharacterId): CharacterUserData {
        return userInfo.find { it.id == id } ?: throw EntityNotFoundException(
            CharacterUserData::class,
            id.value
        )
    }

    override suspend fun find(id: CharacterId): CharacterUserData? {
        return userInfo.find { it.id == id }
    }

    override suspend fun findByIds(ids: Collection<CharacterId>): Map<CharacterId, CharacterUserData> {
        return userInfo
            .filter { it.id in ids }
            .associateBy { it.id }
    }
}
