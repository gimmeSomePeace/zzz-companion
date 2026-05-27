package org.gimmesomepeace.zzzcompanion.data.memory.speciality

import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityFilters
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityRepository
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.net.URI
import java.util.UUID

class InMemorySpecialityRepository : SpecialityRepository {
    private val specialities = listOf(
        Speciality.create(
            SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
            "Anomaly",
            URI(
                "https://static.wikia.nocookie.net/" +
                    "zenless-zone-zero/images/d/d2/Icon_Anomaly.png/" +
                    "revision/latest/scale-to-width-down/32?cb=20240704113735"
            )
        ),
        Speciality.create(
            SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
            "Support",
            URI(
                "https://static.wikia.nocookie.net/" +
                    "zenless-zone-zero/images/2/2f/Icon_Support.png/" +
                    "revision/latest/scale-to-width-down/32?cb=20240704113754"
            )
        )
    )

    override fun getPage(cursor: String?, pageSize: PageSize, filters: SpecialityFilters?): Page<Speciality> {
        val filteredItems = if (filters != null) specialities.applyFilters(filters) else specialities

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSize
        ) { speciality ->
            speciality.id.value.toString()
        }
    }
}
