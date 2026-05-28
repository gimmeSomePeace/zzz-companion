package org.gimmesomepeace.zzzcompanion.core.shared.repository

/**
 * Интерфейс репозитория для операций записи.
 *
 * @param T Тип сущности.
 */
interface WriterRepository<T> {
    /**
     * Сохраняет новую сущность.
     *
     * @param entity Сохраняемая сущность.
     * @throws EntityAlreadyExistsException если сущность с указанным идентификатором уже существует.
     */
    suspend fun create(entity: T)

    /**
     * Обновляет существующую сущность.
     *
     * @param entity Сущность с обновленными данными.
     * @throws EntityNotFoundException если сущность с указанным идентификатором не была найдена.
     */
    suspend fun update(entity: T)

    /**
     * Удаляет существующую сущность.
     *
     * @param entity Удаляемая сущность.
     * @throws EntityNotFoundException если сущность с указанным идентификатором не была найдена.
     */
    suspend fun delete(entity: T)
}
