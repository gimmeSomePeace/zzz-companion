package org.gimmesomepeace.zzzcompanion.core.attribute

/**
 * Набор параметров, по которым выполняется фильтрация атрибутов.
 *
 * @property query строка, используемая при фильтрации по имени атрибута.
 * Null означает, что параметр не применяется.
 */
@ConsistentCopyVisibility
data class AttributeFilters private constructor(
    val query: String? = null,
) {
    companion object {
        fun create(query: String? = null): AttributeFilters {
            val normalizedQuery = query?.trim()?.takeIf { it.isNotEmpty() }
            return AttributeFilters(query = normalizedQuery)
        }
    }

    fun toPredicate(): (Attribute) -> Boolean = { attribute ->
        query?.let { attribute.name.contains(it, ignoreCase = true) } ?: true
    }
}
