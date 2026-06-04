package me.gimmesomepeace.zzzcompanion.data.memory.characteruserdata

import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import me.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import me.gimmesomepeace.zzzcompanion.data.shared.storage.DeleteResult
import me.gimmesomepeace.zzzcompanion.data.shared.storage.InMemoryStorage
import me.gimmesomepeace.zzzcompanion.data.shared.storage.InsertResult
import me.gimmesomepeace.zzzcompanion.data.shared.storage.UpdateResult

class InMemoryCharacterUserDataRepository(
    private val storage: InMemoryStorage<CharacterId, CharacterUserData>,
) : CharacterUserDataRepository {
    override suspend fun get(id: CharacterId): CharacterUserData =
        storage.get(id) ?: throw EntityNotFoundException(
            CharacterUserData::class,
            id.value,
        )

    override suspend fun find(id: CharacterId): CharacterUserData? = storage.get(id)

    override suspend fun findByIds(ids: Collection<CharacterId>): Map<CharacterId, CharacterUserData> =
        storage
            .list()
            .filter { it.id in ids }
            .associateBy { it.id }

    override suspend fun create(entity: CharacterUserData) {
        if (storage.insert(entity) == InsertResult.ALREADY_EXISTS) {
            throw EntityAlreadyExistsException(CharacterUserData::class, entity.id)
        }
    }

    override suspend fun update(entity: CharacterUserData) {
        if (storage.update(entity) == UpdateResult.NOT_FOUND) {
            throw EntityNotFoundException(CharacterUserData::class, entity.id)
        }
    }

    override suspend fun delete(entity: CharacterUserData) {
        if (storage.delete(entity.id) == DeleteResult.NOT_FOUND) {
            throw EntityNotFoundException(CharacterUserData::class, entity.id)
        }
    }
}
