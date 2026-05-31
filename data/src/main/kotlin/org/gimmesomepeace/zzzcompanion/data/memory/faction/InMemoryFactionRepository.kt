package org.gimmesomepeace.zzzcompanion.data.memory.faction

import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionFilters
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionWriterRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.data.memory.InMemoryRepository

private const val MAX_PAGE_SIZE = 100

class InMemoryFactionRepository:
    InMemoryRepository<FactionId, Faction, FactionFilters>({it.id}, Faction::class, PageSize(MAX_PAGE_SIZE)),
    FactionReaderRepository,
    FactionWriterRepository
