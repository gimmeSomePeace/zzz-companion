package me.gimmesomepeace.zzzcompanion.core.attribute

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
    /**
     * Преобразует набор фильтров в предикат для фильтрации атрибутов.
     *
     * @return предикат, оценивающий удовлетворяет ли [Attribute] набору фильтров.
     */
    fun toPredicate(): (Attribute) -> Boolean =
        { attribute ->
            query?.let { attribute.name.contains(it, ignoreCase = true) } ?: true
        }

    companion object {
        /**
         * Создает набор фильтров, проверяя инварианты.
         *
         * @param query Поисковая строка.
         * @return набор фильтров, с гарантированным валидным состоянием.
         */
        fun create(query: String? = null): AttributeFilters {
            val normalizedQuery = query?.trim()?.takeIf { it.isNotEmpty() }
            return AttributeFilters(query = normalizedQuery)
        }
    }
}
