package me.gimmesomepeace.zzzcompanion.data.memory.character

import me.gimmesomepeace.zzzcompanion.core.character.Character
import me.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import me.gimmesomepeace.zzzcompanion.core.character.repository.CharacterWriterRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import me.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import me.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import me.gimmesomepeace.zzzcompanion.data.shared.paginate
import me.gimmesomepeace.zzzcompanion.data.shared.storage.DeleteResult
import me.gimmesomepeace.zzzcompanion.data.shared.storage.InMemoryStorage
import me.gimmesomepeace.zzzcompanion.data.shared.storage.InsertResult
import me.gimmesomepeace.zzzcompanion.data.shared.storage.UpdateResult
import kotlin.math.min

private const val MAX_PAGE_SIZE = 100

class InMemoryCharacterRepository(
    private val storage: InMemoryStorage<CharacterId, Character>,
) : CharacterReaderRepository,
    CharacterWriterRepository {
    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: CharacterFilters?,
    ): Page<Character> {
        val characters =
            storage.list(
                filter = filters?.toPredicate(),
                sort = { a, b -> a.id.value.compareTo(b.id.value) },
            )

        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        return characters.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped,
        ) { character ->
            character.id.value.toString()
        }
    }

    override suspend fun get(id: CharacterId): Character =
        storage.get(id) ?: throw EntityNotFoundException(Character::class, id.value)

    override suspend fun find(id: CharacterId): Character? = storage.get(id)

    override suspend fun findByIds(ids: Collection<CharacterId>): Map<CharacterId, Character> =
        storage
            .list()
            .filter { it.id in ids }
            .associateBy { it.id }

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
