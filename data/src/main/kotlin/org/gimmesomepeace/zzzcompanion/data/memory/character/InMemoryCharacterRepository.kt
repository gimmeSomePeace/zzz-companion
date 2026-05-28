package org.gimmesomepeace.zzzcompanion.data.memory.character

import org.gimmesomepeace.zzzcompanion.core.character.Character
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterWriterRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import org.gimmesomepeace.zzzcompanion.data.shared.storage.DeleteResult
import org.gimmesomepeace.zzzcompanion.data.shared.storage.InMemoryStorage
import org.gimmesomepeace.zzzcompanion.data.shared.storage.InsertResult
import org.gimmesomepeace.zzzcompanion.data.shared.storage.UpdateResult
import kotlin.math.min

private const val MAX_PAGE_SIZE = 100

class InMemoryCharacterRepository(
    private val storage: InMemoryStorage<CharacterId, Character>
) :
    CharacterReaderRepository,
    CharacterWriterRepository
{
    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: CharacterFilters?
    ): Page<Character> {
        val characters = storage.getAll()

        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        val filteredItems = if (filters != null) characters.applyFilters(filters) else characters

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped,
        ) { character ->
            character.id.value.toString()
        }
    }

    override suspend fun get(id: CharacterId): Character {
        return storage.get(id) ?: throw EntityNotFoundException(Character::class, id.value)
    }

    override suspend fun find(id: CharacterId): Character? {
        return storage.get(id)
    }

    override suspend fun findByIds(
        ids: Collection<CharacterId>
    ): Map<CharacterId, Character> {
        return storage.getAll()
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Character) {
        if (storage.insert(entity) == InsertResult.ALREADY_EXISTS) {
            throw EntityAlreadyExistsException(Character::class, entity.id)
        }
    }

    override suspend fun update(entity: Character) {
        if (storage.update(entity) == UpdateResult.NOT_FOUND) {
            throw EntityNotFoundException(Character::class, entity.id)
        }
    }

    override suspend fun delete(entity: Character) {
        if (storage.delete(entity.id) == DeleteResult.NOT_FOUND) {
            throw EntityNotFoundException(Character::class, entity.id)
        }
    }
}
