package org.gimmesomepeace.zzzcompanion.data.storage.local.speciality

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FakeSpecialityLocalDataSource: SpecialityLocalDataSource {
    private val specialities = MutableStateFlow(
        listOf(
            SpecialityLocalEntity(
                "1",
                "Anomaly",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d2/Icon_Anomaly.png/revision/latest/scale-to-width-down/32?cb=20240704113735"
            ),
            SpecialityLocalEntity(
                "2",
                "Support",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/2/2f/Icon_Support.png/revision/latest/scale-to-width-down/32?cb=20240704113754"
            )
        )
    )

    override fun getAll(): Flow<List<SpecialityLocalEntity>> {
        return specialities.asStateFlow()
    }
}