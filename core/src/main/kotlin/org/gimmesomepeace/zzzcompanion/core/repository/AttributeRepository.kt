package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.characters.AttributeFilters


interface AttributeRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: AttributeFilters? = null,
    ): Page<Attribute>
}
