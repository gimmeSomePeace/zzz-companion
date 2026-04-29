package org.gimmesomepeace.zzzcompanion.data.storage.local.faction

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URI


class FakeFactionLocalDataSource : FactionLocalDataSource {
    private val factions = MutableStateFlow(
        listOf(
            FactionLocalEntity(
                "1",
                "Victoria Housekeeping Co.",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/revision/latest?cb=20240915104752")
            ),
            FactionLocalEntity(
                "2",
                "Spook Shack",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/revision/latest?cb=20250608103142")
            )
        )
    )

    override fun getAll(): Flow<List<FactionLocalEntity>> {
        return factions.asStateFlow()
    }

}