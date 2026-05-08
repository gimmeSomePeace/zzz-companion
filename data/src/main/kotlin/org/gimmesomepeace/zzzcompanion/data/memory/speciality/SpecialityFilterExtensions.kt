package org.gimmesomepeace.zzzcompanion.data.memory.speciality

import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityFilters


fun List<Speciality>.applyFilters(filters: SpecialityFilters) = this.filter {
    filters.query == null ||
    filters.query!!.isBlank() ||
    it.name.contains(filters.query!!, ignoreCase = true)
}
