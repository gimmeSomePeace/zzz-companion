package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.Rarity
import org.zzzcompanion.features.characters.data.entities.RarityId

class RarityRepository {
    private val _rarities = MutableStateFlow<List<Rarity>>(emptyList())
    val rarities: StateFlow<List<Rarity>> = _rarities.asStateFlow()

    init {
        _rarities.value = listOf(
            Rarity(
                RarityId("1"),
                "S",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d0/Icon_AgentRank_S.png/revision/latest/scale-to-width-down/32?cb=20240914140011"
            ),
            Rarity(
                RarityId("2"),
                "A",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/5/5c/Icon_AgentRank_A.png/revision/latest/scale-to-width-down/32?cb=20240914135957"
            )
        )
    }

    fun getAll(): List<Rarity> = _rarities.value
    fun getById(id: RarityId): Rarity? = _rarities.value.firstOrNull { it.id == id }
}
