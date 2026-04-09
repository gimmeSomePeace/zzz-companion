package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.Rarity

class RarityRepository {
    private val rarities: List<Rarity> = listOf(
        Rarity(1, "S", "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d0/Icon_AgentRank_S.png/revision/latest/scale-to-width-down/32?cb=20240914140011"),
        Rarity(2, "A", "https://static.wikia.nocookie.net/zenless-zone-zero/images/5/5c/Icon_AgentRank_A.png/revision/latest/scale-to-width-down/32?cb=20240914135957")
    )

    fun getAll(): List<Rarity> = rarities
    fun getById(id: Long): Rarity? = rarities.firstOrNull { it.id == id }
}
