package org.gimmesomepeace.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId


class FactionRepository {
    private val _factions = MutableStateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction>>(emptyList())
    val factions: StateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction>> = _factions.asStateFlow()

    init {
        _factions.value = listOf(
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId("1"),
                "Victoria Housekeeping Co.",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/revision/latest?cb=20240915104752"
            ),
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId("2"),
                "Spook Shack",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/revision/latest?cb=20250608103142"
            )
        )
    }

    fun getAll(): List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction> = _factions.value
    fun getById(id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId): org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction? = _factions.value.firstOrNull { it.id == id }
}