package me.gimmesomepeace.zzzcompanion.core.speciality

import me.gimmesomepeace.zzzcompanion.core.attribute.Attribute

/**
 * Набор параметров, по которым выполняется фильтрация специализаций.
 *
 * @property query строка, используемая при фильтрации по названию специализации.
 * Null означает, что параметр не применяется.
 */
@ConsistentCopyVisibility
data class SpecialityFilters private constructor(
    val query: String? = null,
) {
    /**
     * Преобразует набор фильтров в предикат для фильтрации атрибутов.
     *
     * @return предикат, оценивающий удовлетворяет ли [Attribute] набору фильтров.
     */
    fun toPredicate(): (Speciality) -> Boolean =
        { speciality ->
            query?.let { speciality.name.contains(it, ignoreCase = true) } ?: true
        }

    companion object {
        /**
         * Создает набор фильтров, проверяя инварианты.
         *
         * @param query Поисковая строка.
         * @return набор фильтров, с гарантированным валидным состоянием.
         */
        fun create(query: String? = null): SpecialityFilters {
            val normalized = query?.trim()?.takeIf { it.isNotEmpty() }
            return SpecialityFilters(query = normalized)
        }
    }
}
