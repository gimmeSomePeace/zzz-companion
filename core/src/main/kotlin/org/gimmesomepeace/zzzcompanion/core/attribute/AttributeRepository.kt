package org.gimmesomepeace.zzzcompanion.core.attribute

import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize


interface AttributeRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: AttributeFilters? = null,
    ): Page<Attribute>
}
