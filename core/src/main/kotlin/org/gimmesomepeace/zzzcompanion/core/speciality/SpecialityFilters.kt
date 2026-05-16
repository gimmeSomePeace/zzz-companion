package org.gimmesomepeace.zzzcompanion.core.speciality

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
    companion object {
        fun create(query: String? = null): SpecialityFilters {
            return SpecialityFilters(query = normalizeQuery(query))
        }

        private fun normalizeQuery(query: String?): String? {
            return query?.trim()
        }
    }
}
