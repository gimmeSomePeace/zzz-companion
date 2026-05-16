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
            return AttributeFilters(query = normalizeQuery(query))
        }

        private fun normalizeQuery(query: String?): String? {
            return query?.trim()
        }
    }
}
