package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.characters.SpecialityFilters


interface SpecialityRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: SpecialityFilters? = null,
    ) : Page<Speciality>
}