package org.gimmesomepeace.zzzcompanion.data.memory.speciality

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
import org.gimmesomepeace.zzzcompanion.data.shared.storage.DeleteResult
import org.gimmesomepeace.zzzcompanion.data.shared.storage.InMemoryStorage
import org.gimmesomepeace.zzzcompanion.data.shared.storage.InsertResult
import org.gimmesomepeace.zzzcompanion.data.shared.storage.UpdateResult
import kotlin.math.min

private const val MAX_PAGE_SIZE = 100

class InMemorySpecialityRepository(
    private val storage: InMemoryStorage<SpecialityId, Speciality>
) :
    SpecialityReaderRepository,
    SpecialityWriterRepository
{
    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: SpecialityFilters?
    ): Page<Speciality> {
        val specialities = storage.getAll()

        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        val filteredItems = if (filters != null) specialities.applyFilters(filters) else specialities

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped
        ) { speciality ->
            speciality.id.value.toString()
        }
    }

    override suspend fun get(id: SpecialityId): Speciality {
        return storage.get(id) ?: throw EntityNotFoundException(
            Speciality::class,
            id.value
        )
    }

    override suspend fun find(id: SpecialityId): Speciality? {
        return storage.get(id)
    }

    override suspend fun findByIds(
        ids: Collection<SpecialityId>
    ): Map<SpecialityId, Speciality> {
        return storage.getAll()
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Speciality) {
        if (storage.insert(entity) == InsertResult.ALREADY_EXISTS)
            throw EntityAlreadyExistsException(Speciality::class, entity.id)
    }

    override suspend fun update(entity: Speciality) {
        if (storage.update(entity) == UpdateResult.NOT_FOUND)
            throw EntityNotFoundException(Speciality::class, entity.id)
    }

    override suspend fun delete(entity: Speciality) {
        if (storage.delete(entity.id) == DeleteResult.NOT_FOUND)
            throw EntityNotFoundException(Speciality::class, entity.id)
    }
}
