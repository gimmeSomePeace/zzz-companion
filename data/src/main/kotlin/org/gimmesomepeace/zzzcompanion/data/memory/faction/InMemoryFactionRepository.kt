package org.gimmesomepeace.zzzcompanion.data.memory.faction

import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionFilters
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionWriterRepository
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

class InMemoryFactionRepository(
    private val storage: InMemoryStorage<FactionId, Faction>
) :
    FactionReaderRepository,
    FactionWriterRepository
{
    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: FactionFilters?
    ): Page<Faction> {
        val factions = storage.getAll()

        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        val filteredItems = if (filters != null) factions.applyFilters(filters) else factions

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped
        ) { character ->
            character.id.value.toString()
        }
    }

    override suspend fun get(id: FactionId): Faction {
        return storage.get(id) ?: throw EntityNotFoundException(Faction::class, id.value)
    }

    override suspend fun find(id: FactionId): Faction? {
        return storage.get(id)
    }

    override suspend fun findByIds(
        ids: Collection<FactionId>
    ): Map<FactionId, Faction> {
        return storage.getAll()
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Faction) {
        if (storage.insert(entity) == InsertResult.ALREADY_EXISTS)
            throw EntityAlreadyExistsException(Faction::class, entity.id)
    }

    override suspend fun update(entity: Faction) {
        if (storage.update(entity) == UpdateResult.NOT_FOUND)
            throw EntityNotFoundException(Faction::class, entity.id)
    }

    override suspend fun delete(entity: Faction) {
        if (storage.delete(entity.id) == DeleteResult.NOT_FOUND)
            throw EntityNotFoundException(Faction::class, entity.id)
    }
}
