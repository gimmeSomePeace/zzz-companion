package org.gimmesomepeace.zzzcompanion.data.memory

import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionFilters
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionRepository
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.net.URI
import java.util.UUID

class InMemoryFactionRepository : FactionRepository {
    private val factions = listOf(
        Faction(
            FactionId(UUID.fromString("f0a2b3ed-beda-4975-aa25-d9c1146ade00")),
            "Victoria Housekeeping Co.",
            URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/a/a4/Faction_Victoria_Housekeeping_Co._Icon.png/revision/latest?cb=20240915104752")
        ),
        Faction(
            FactionId(UUID.fromString("021583e1-1f01-488a-a842-bb2195e4cd6e")),
            "Spook Shack",
            URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/1/18/Faction_Spook_Shack_Icon.png/revision/latest?cb=20250608103142")
        )
    )

    override fun getPage(
        cursor: String?,
        pageSize: PageSize,
        filters: FactionFilters?
    ): Page<Faction> {
        val filteredItems = if (filters != null) applyFilters(factions, filters) else factions

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSize
        ) { character ->
            character.id.value.toString()
        }
    }

    private fun applyFilters(
        factions: List<Faction>,
        filters: FactionFilters
    ): List<Faction> = factions.filter {
        filters.query == null || filters.query!!.isBlank() || it.name.contains(filters.query!!, ignoreCase = true)
    }
}