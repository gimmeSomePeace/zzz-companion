package org.gimmesomepeace.zzzcompanion.core.faction

import org.gimmesomepeace.zzzcompanion.core.shared.Filter

/**
 * Набор параметров, по которым выполняется фильтрация фракций.
 *
 * @property query строка, используемая при фильтрации по названию фракции.
 * Null означает, что параметр не применяется.
 */
@ConsistentCopyVisibility
data class FactionFilters private constructor(
    val query: String? = null,
) : Filter<Faction> {
    companion object {
        fun create(query: String? = null): FactionFilters {
            val normalized = query?.trim()?.takeIf { it.isNotEmpty() }
            return FactionFilters(query = normalized)
        }
    }

    override fun toPredicate(): (Faction) -> Boolean = { faction ->
        query?.let { faction.name.contains(it, ignoreCase = true) } ?: true
    }
}
