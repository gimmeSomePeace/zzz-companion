package org.gimmesomepeace.zzzcompanion.data.rariry.memory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.repository.RarityRepository
import java.net.URI
import java.util.UUID

class InMemoryRarityRepository : RarityRepository {
    private val rarities = MutableStateFlow(
        listOf(
            Rarity(
                RarityId(UUID.fromString("d0833aa8-0b65-4668-a8ca-27492be44817")),
                "S",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d0/Icon_AgentRank_S.png/revision/latest/scale-to-width-down/32?cb=20240914140011")
            ),
            Rarity(
                RarityId(UUID.fromString("c6d33de6-aa82-4fc1-aa2f-bee21b442cf3")),
                "A",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/5/5c/Icon_AgentRank_A.png/revision/latest/scale-to-width-down/32?cb=20240914135957")
            )
        )
    )

    override fun getAll(): Flow<List<Rarity>> = rarities
}