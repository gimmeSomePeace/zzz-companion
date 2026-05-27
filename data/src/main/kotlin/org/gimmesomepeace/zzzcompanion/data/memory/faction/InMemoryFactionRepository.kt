package org.gimmesomepeace.zzzcompanion.data.memory.faction

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
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
import java.net.URI
import java.util.UUID
import kotlin.collections.plus
import kotlin.math.min

private const val MAX_PAGE_SIZE = 100

class InMemoryFactionRepository :
    FactionReaderRepository,
    FactionWriterRepository
{
    private val mutex = Mutex()

    private var factions = listOf(
        Faction.create(
            FactionId(UUID.fromString("f0a2b3ed-beda-4975-aa25-d9c1146ade00")),
            "Victoria Housekeeping Co.",
            URI(
                "https://static.wikia.nocookie.net/" +
                    "zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/" +
                    "revision/latest?cb=20240915104752"
            )
        ),
        Faction.create(
            FactionId(UUID.fromString("021583e1-1f01-488a-a842-bb2195e4cd6e")),
            "Spook Shack",
            URI(
                "https://static.wikia.nocookie.net/" +
                    "zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/" +
                    "revision/latest?cb=20250608103142"
            )
        )
    )

    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: FactionFilters?
    ): Page<Faction> = mutex.withLock {
        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        val filteredItems = if (filters != null) factions.applyFilters(filters) else factions

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped
        ) { character ->
            character.id.value.toString()
        }
    }

    override suspend fun get(id: FactionId): Faction = mutex.withLock {
        return factions.find { it.id == id } ?: throw EntityNotFoundException(
            Faction::class,
            id.value
        )
    }

    override suspend fun find(id: FactionId): Faction? = mutex.withLock {
        return factions.find { it.id == id }
    }

    override suspend fun findByIds(
        ids: Collection<FactionId>
    ): Map<FactionId, Faction> = mutex.withLock {
        return factions
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Faction) = mutex.withLock {
        if (factions.any { it.id == entity.id })
            throw EntityAlreadyExistsException(Faction::class, entity.id)
        factions += entity
    }

    override suspend fun update(entity: Faction) = mutex.withLock {
        val index = factions.indexOfFirst { it.id == entity.id }
        if (index == -1) throw EntityNotFoundException(Faction::class, entity.id)

        factions = factions.map { if (it.id == entity.id) entity else it }
    }

    override suspend fun delete(entity: Faction) = mutex.withLock {
        val sizeBefore = factions.size
        factions = factions.filter { it.id != entity.id }

        if (factions.size == sizeBefore)
            throw EntityNotFoundException(Faction::class, entity.id)
    }
}
