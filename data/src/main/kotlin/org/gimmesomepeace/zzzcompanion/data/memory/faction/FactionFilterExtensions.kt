package org.gimmesomepeace.zzzcompanion.data.memory.faction

import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionFilters

internal fun List<Faction>.applyFilters(filters: FactionFilters) = this.filter {
    filters.query == null ||
    filters.query!!.isBlank() ||
        it.name.contains(filters.query!!, ignoreCase = true)
}
