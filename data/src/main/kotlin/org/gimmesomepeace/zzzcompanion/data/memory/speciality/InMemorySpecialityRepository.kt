package org.gimmesomepeace.zzzcompanion.data.memory.speciality

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityFilters
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityWriterRepository
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.net.URI
import java.util.UUID
import kotlin.collections.plus
import kotlin.math.min

private const val MAX_PAGE_SIZE = 100

class InMemorySpecialityRepository :
    SpecialityReaderRepository,
    SpecialityWriterRepository
{
    private val mutex = Mutex()

    private var specialities = listOf(
        Speciality.create(
            SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
            "Anomaly",
            URI(
                "https://static.wikia.nocookie.net/" +
                    "zenless-zone-zero/images/d/d2/Icon_Anomaly.png/" +
                    "revision/latest/scale-to-width-down/32?cb=20240704113735"
            )
        ),
        Speciality.create(
            SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
            "Support",
            URI(
                "https://static.wikia.nocookie.net/" +
                    "zenless-zone-zero/images/2/2f/Icon_Support.png/" +
                    "revision/latest/scale-to-width-down/32?cb=20240704113754"
            )
        )
    )

    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: SpecialityFilters?
    ): Page<Speciality> = mutex.withLock {
        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        val filteredItems = if (filters != null) specialities.applyFilters(filters) else specialities

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped
        ) { speciality ->
            speciality.id.value.toString()
        }
    }

    override suspend fun get(id: SpecialityId): Speciality = mutex.withLock {
        return specialities.find { it.id == id } ?: throw EntityNotFoundException(
            Speciality::class,
            id.value
        )
    }

    override suspend fun find(id: SpecialityId): Speciality? = mutex.withLock {
        return specialities.find { it.id == id }
    }

    override suspend fun findByIds(
        ids: Collection<SpecialityId>
    ): Map<SpecialityId, Speciality> = mutex.withLock {
        return specialities
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Speciality) = mutex.withLock {
        if (specialities.any { it.id == entity.id })
            throw EntityAlreadyExistsException(Speciality::class, entity.id)
        specialities += entity
    }

    override suspend fun update(entity: Speciality) = mutex.withLock {
        val index = specialities.indexOfFirst { it.id == entity.id }
        if (index == -1) throw EntityNotFoundException(Speciality::class, entity.id)

        specialities = specialities.map { if (it.id == entity.id) entity else it }
    }

    override suspend fun delete(entity: Speciality) = mutex.withLock {
        val sizeBefore = specialities.size
        specialities = specialities.filter { it.id != entity.id }

        if (specialities.size == sizeBefore)
            throw EntityNotFoundException(Speciality::class, entity.id)
    }
}
