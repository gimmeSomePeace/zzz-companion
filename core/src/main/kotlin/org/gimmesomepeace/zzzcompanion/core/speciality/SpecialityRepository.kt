package org.gimmesomepeace.zzzcompanion.core.speciality

import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize


interface SpecialityRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: SpecialityFilters? = null,
    ) : Page<Speciality>
}