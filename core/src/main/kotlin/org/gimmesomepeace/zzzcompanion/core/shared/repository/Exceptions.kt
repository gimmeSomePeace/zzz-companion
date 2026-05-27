package org.gimmesomepeace.zzzcompanion.core.shared.repository

/**
 * Исключение, выбрасываемое при отсутствии сущности с указанным идентификатором.
 *
 * @param entity Название сущности.
 * @param id Идентификатор сущности.
 */
class EntityNotFoundException(
    entity: String,
    id: Any
) : NoSuchElementException("Entity $entity with id=$id not found")

/**
 * Исключение, выбрасываемое при попытке создать сущность с уже существующим идентификатором.
 *
 * @param entity Название сущности.
 * @param id Идентификатор сущности.
 */
class EntityAlreadyExistsException(
    entity: String,
    id: Any
) : Exception("Entity $entity with id=$id already exists")
