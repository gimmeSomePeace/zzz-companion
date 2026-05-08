package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction
import org.gimmesomepeace.zzzcompanion.core.model.characters.FactionFilters


interface FactionRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: FactionFilters? = null,
    ) : Page<Faction>
}
