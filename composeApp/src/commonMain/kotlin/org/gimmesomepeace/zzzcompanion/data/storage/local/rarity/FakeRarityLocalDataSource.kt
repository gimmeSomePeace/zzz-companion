package org.gimmesomepeace.zzzcompanion.data.storage.local.rarity

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URI


class FakeRarityLocalDataSource : RarityLocalDataSource {
    private val rarities = MutableStateFlow(
        listOf(
            RarityLocalEntity(
                "1",
                "S",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d0/Icon_AgentRank_S.png/revision/latest/scale-to-width-down/32?cb=20240914140011")
            ),
            RarityLocalEntity(
                "2",
                "A",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/5/5c/Icon_AgentRank_A.png/revision/latest/scale-to-width-down/32?cb=20240914135957")
            )
        )
    )

    override fun getAll(): Flow<List<RarityLocalEntity>> {
        return rarities.asStateFlow()
    }
}