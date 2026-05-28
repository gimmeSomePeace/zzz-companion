package org.gimmesomepeace.zzzcompanion.data.shared.storage

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class InMemoryListStorage<ID, E>(
    initialItems : List<E>,
    val idSelector : (E) -> ID
): InMemoryStorage<ID, E> {
    private val items = initialItems.toMutableList()
    private val mutex = Mutex()

    override suspend fun get(id: ID): E? = mutex.withLock {
        return items.find { idSelector(it) == id }
    }

    override suspend fun getAll(): List<E> = mutex.withLock {
        return items
    }

    override suspend fun insert(entity: E): InsertResult = mutex.withLock {
        val entityId = idSelector(entity)
        if (items.any {idSelector(it) == entityId}) return InsertResult.ALREADY_EXISTS

        items.add(entity)
        return InsertResult.SUCCESS
    }

    override suspend fun update(entity: E): UpdateResult = mutex.withLock {
        val entityId = idSelector(entity)
        val entityPosition = items.indexOfFirst { idSelector(it) == entityId }
        if (entityPosition == -1) return UpdateResult.NOT_FOUND

        items[entityPosition] = entity
        return UpdateResult.SUCCESS
    }

    override suspend fun delete(id: ID): DeleteResult = mutex.withLock {
        val entityPosition = items.indexOfFirst { idSelector(it) == id }
        if (entityPosition == -1) return DeleteResult.NOT_FOUND

        items.removeAt(entityPosition)
        return DeleteResult.SUCCESS
    }
}
