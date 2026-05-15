package org.gimmesomepeace.zzzcompanion.core.attribute

/**
 * Набор параметров, по которым выполняется фильтрация атрибутов.
 *
 * @property query строка, используемая при фильтрации по имени атрибута.
 * Null означает, что параметр не применяется.
 */
data class AttributeFilters(
    val query: String? = null,
)
