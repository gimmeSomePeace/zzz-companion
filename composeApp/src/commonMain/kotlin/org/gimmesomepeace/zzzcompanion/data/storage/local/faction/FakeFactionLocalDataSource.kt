package org.gimmesomepeace.zzzcompanion.data.storage.local.faction

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URI


class FakeFactionLocalDataSource : FactionLocalDataSource {
    private val factions = MutableStateFlow(
        listOf(
            FactionLocalEntity(
                "f0a2b3ed-beda-4975-aa25-d9c1146ade00",
                "Victoria Housekeeping Co.",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/revision/latest?cb=20240915104752")
            ),
            FactionLocalEntity(
                "021583e1-1f01-488a-a842-bb2195e4cd6e",
                "Spook Shack",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/revision/latest?cb=20250608103142")
            )
        )
    )

    override fun getAll(): Flow<List<FactionLocalEntity>> {
        return factions.asStateFlow()
    }

}