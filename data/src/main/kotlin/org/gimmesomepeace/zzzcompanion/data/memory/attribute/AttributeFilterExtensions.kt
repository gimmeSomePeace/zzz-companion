package org.gimmesomepeace.zzzcompanion.data.memory.attribute

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeFilters

fun List<Attribute>.applyFilters(filters: AttributeFilters) = this.filter {
    filters.query == null ||
    filters.query!!.isBlank() ||
        it.name.contains(filters.query!!, ignoreCase = true)
}
