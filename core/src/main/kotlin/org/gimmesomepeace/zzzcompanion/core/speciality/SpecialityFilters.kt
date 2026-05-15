package org.gimmesomepeace.zzzcompanion.core.speciality

/**
 * Набор параметров, по которым выполняется фильтрация специализаций.
 *
 * @property query строка, используемая при фильтрации по названию специализации.
 * Null означает, что параметр не применяется.
 */
data class SpecialityFilters(
    val query: String? = null,
)
