package org.gimmesomepeace.zzzcompanion.data.shared.storage

enum class InsertResult {
    SUCCESS,
    ALREADY_EXISTS,
}

enum class UpdateResult {
    SUCCESS,
    NOT_FOUND
}

enum class DeleteResult {
    SUCCESS,
    NOT_FOUND
}

interface InMemoryStorage<ID, E> {
    suspend fun get(id: ID): E?
    suspend fun getAll(): List<E>
    suspend fun insert(entity: E): InsertResult
    suspend fun update(entity: E): UpdateResult
    suspend fun delete(id: ID): DeleteResult
}