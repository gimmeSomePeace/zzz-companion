package org.gimmesomepeace.zzzcompanion.core.faction

import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize


interface FactionRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: FactionFilters? = null,
    ) : Page<Faction>
}
