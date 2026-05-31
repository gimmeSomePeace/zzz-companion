package org.gimmesomepeace.zzzcompanion.data.memory

import org.gimmesomepeace.zzzcompanion.core.shared.Filter
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.WriterRepository
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.min
import kotlin.reflect.KClass

open class InMemoryRepository<ID : Any, E : Any, F : Filter<E>>(
    val idSelector: (E) -> ID,
    private val kClass: KClass<E>,
    private val maxPageSize: PageSize,
) : ReaderRepository<ID, E>, WriterRepository<E>, PaginationRepository<E, F> {
    private val storage = ConcurrentHashMap<ID, E>()

    override suspend fun get(id: ID): E {
        return storage[id] ?: throw EntityNotFoundException(kClass, id)
    }

    override suspend fun find(id: ID): E? {
        return storage[id]
    }

    override suspend fun findByIds(ids: Collection<ID>): Map<ID, E> {
        return ids.mapNotNull { id ->
            storage[id]?.let { value -> id to value }
        }.toMap()
    }

    override suspend fun create(entity: E) {
        val entityId = idSelector(entity)
        if (storage.containsKey(entityId)) throw EntityAlreadyExistsException(kClass, entityId)

        storage[entityId] = entity
    }

    override suspend fun update(entity: E) {
        val entityId = idSelector(entity)
        if (!storage.containsKey(entityId)) throw EntityNotFoundException(kClass, entityId)

        storage[entityId] = entity
    }

    override suspend fun delete(entity: E) {
        val entityId = idSelector(entity)
        if (!storage.containsKey(entityId)) throw EntityNotFoundException(kClass, entityId)

        storage.remove(entityId)
    }

    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: F?
    ): Page<E> {
        val elements =
            if (filters != null) storage.values.filter(filters.toPredicate())
            else storage.values

        val pageSizeClamped = PageSize(min(pageSize.value, maxPageSize.value))

        return elements.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped
        ) { idSelector(it).toString() }
    }


}
