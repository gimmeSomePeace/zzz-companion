package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.Faction


class FactionRepository {
    private val _factions = MutableStateFlow<List<Faction>>(emptyList())
    val factions: StateFlow<List<Faction>> = _factions.asStateFlow()

    init {
        listOf(
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
    }

    fun getAll(): List<Faction> = _factions.value
    fun getById(id: Long): Faction? = _factions.value.firstOrNull { it.id == id }
}