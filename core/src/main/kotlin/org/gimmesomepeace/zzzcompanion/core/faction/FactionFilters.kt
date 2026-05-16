package org.gimmesomepeace.zzzcompanion.core.faction

/**
 * Набор параметров, по которым выполняется фильтрация фракций.
 *
 * @property query строка, используемая при фильтрации по названию фракции.
 * Null означает, что параметр не применяется.
 */
@ConsistentCopyVisibility
data class FactionFilters private constructor(
    val query: String? = null,
) {
    companion object {
        fun create(query: String? = null): FactionFilters {
            return FactionFilters(query = normalizeQuery(query))
        }

        private fun normalizeQuery(query: String?): String? {
            return query?.trim()
        }
    }
}
