package org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import java.util.UUID

class InMemoryCharacterUserDataRepository : CharacterUserDataRepository {

    private var userInfo = listOf(
        CharacterUserData.create(
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
            EquippedDisks.create()
        )
    )

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

    override suspend fun create(entity: CharacterUserData) {
        if (userInfo.any { it.id == entity.id })
            throw EntityAlreadyExistsException(CharacterUserData::class, entity.id)
        userInfo += entity
    }

    override suspend fun update(entity: CharacterUserData) {
        val index = userInfo.indexOfFirst { it.id == entity.id }
        if (index == -1) throw EntityNotFoundException(CharacterUserData::class, entity.id)

        userInfo = userInfo.map { if (it.id == entity.id) entity else it }
    }

    override suspend fun delete(entity: CharacterUserData) {
        val sizeBefore = userInfo.size
        userInfo = userInfo.filter { it.id != entity.id }

        if (userInfo.size == sizeBefore)
            throw EntityNotFoundException(CharacterUserData::class, entity.id)
    }
}
