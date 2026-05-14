package org.gimmesomepeace.zzzcompanion.data.memory.faction

import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionFilters

fun List<Faction>.applyFilters(filters: FactionFilters) = this.filter {
    filters.query.isBlank() ||
    it.name.contains(filters.query, ignoreCase = true)
}
