package org.gimmesomepeace.zzzcompanion.data.memory.attribute

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeFilters
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeWriterRepository
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

class InMemoryAttributeRepository(
    private val storage: InMemoryStorage<AttributeId, Attribute>,
) :
    AttributeReaderRepository,
    AttributeWriterRepository
{
    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: AttributeFilters?
    ): Page<Attribute> {
        val attributes = storage.list(
            filter = filters?.toPredicate(),
            sort = {a, b -> a.id.value.compareTo(b.id.value) }
        )

        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))

        return attributes.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped
        ) { attribute ->
            attribute.id.value.toString()
        }
    }

    override suspend fun get(id: AttributeId): Attribute {
        return storage.get(id) ?: throw EntityNotFoundException(Attribute::class, id.value)
    }

    override suspend fun find(id: AttributeId): Attribute? {
        return storage.get(id)
    }

    override suspend fun findByIds(
        ids: Collection<AttributeId>
    ): Map<AttributeId, Attribute> {
        return storage.list()
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Attribute) {
        if (storage.insert(entity) == InsertResult.ALREADY_EXISTS)
            throw EntityAlreadyExistsException(Attribute::class, entity.id)
    }

    override suspend fun update(entity: Attribute) {
        if (storage.update(entity) == UpdateResult.NOT_FOUND)
            throw EntityNotFoundException(Attribute::class, entity.id)
    }

    override suspend fun delete(entity: Attribute) {
        if (storage.delete(entity.id) == DeleteResult.NOT_FOUND)
            throw EntityNotFoundException(Attribute::class, entity.id)
    }
}
