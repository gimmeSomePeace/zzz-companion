package org.gimmesomepeace.zzzcompanion.data.speciality.memory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.repository.SpecialityRepository
import java.net.URI
import java.util.UUID

class InMemorySpecialityRepository : SpecialityRepository {
    private val specialities = MutableStateFlow(
        listOf(
            Speciality(
                SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
                "Anomaly",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d2/Icon_Anomaly.png/revision/latest/scale-to-width-down/32?cb=20240704113735")
            ),
            Speciality(
                SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
                "Support",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/2/2f/Icon_Support.png/revision/latest/scale-to-width-down/32?cb=20240704113754")
            )
        )
    )

    override fun getAll(): Flow<List<Speciality>> = specialities
}