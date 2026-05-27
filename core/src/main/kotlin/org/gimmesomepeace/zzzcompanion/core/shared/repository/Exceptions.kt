package org.gimmesomepeace.zzzcompanion.core.shared.repository

import kotlin.reflect.KClass

/**
 * Исключение, выбрасываемое при отсутствии сущности с указанным идентификатором.
 *
 * @param entity Тип сущности.
 * @param id Идентификатор сущности.
 */
class EntityNotFoundException(
    entity: KClass<*>,
    id: Any
) : NoSuchElementException("Entity ${entity.simpleName ?: entity.qualifiedName} with id=$id not found")

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
