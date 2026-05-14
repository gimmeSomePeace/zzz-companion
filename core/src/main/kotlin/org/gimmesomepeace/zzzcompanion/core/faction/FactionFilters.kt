package org.gimmesomepeace.zzzcompanion.core.faction

/**
 * Набор параметров, по которым выполняется фильтрация фракций.
 *
 * @property query строка, используемая при фильтрации по названию фракции.
 * Пустая строка означает, что параметр не применяется.
 */
data class FactionFilters(
    val query: String = "",
)
