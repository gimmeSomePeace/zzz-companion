package org.zzzcompanion.features.characters.data.repository

import org.zzzcompanion.features.characters.data.entities.Faction

class FactionRepository {
    private val factions = listOf(
        Faction(
            1,
            "Victoria Housekeeping Co.",
            "https://static.wikia.nocookie.net/zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/revision/latest?cb=20240915104752"
        ),
        Faction(
            2,
            "Spook Shack",
            "https://static.wikia.nocookie.net/zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/revision/latest?cb=20250608103142"
        )
    )

    fun getAll(): List<Faction> = factions
    fun getById(id: Long): Faction? = factions.firstOrNull { it.id == id }
}