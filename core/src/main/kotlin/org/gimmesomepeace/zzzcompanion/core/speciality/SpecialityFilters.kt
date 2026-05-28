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
            val normalized = query?.trim()?.takeIf { it.isNotEmpty() }
            return SpecialityFilters(query = normalized)
        }
    }

    fun toPredicate(): (Speciality) -> Boolean = { speciality ->
        query?.let { speciality.name.contains(it, ignoreCase = true) } ?: true
    }
}
