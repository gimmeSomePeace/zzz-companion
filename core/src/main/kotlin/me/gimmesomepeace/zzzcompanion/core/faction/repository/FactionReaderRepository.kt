package me.gimmesomepeace.zzzcompanion.core.faction.repository

import me.gimmesomepeace.zzzcompanion.core.faction.Faction
import me.gimmesomepeace.zzzcompanion.core.faction.FactionFilters
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface FactionReaderRepository:
    ReaderRepository<Faction, FactionId>,
    PaginationRepository<Faction, FactionFilters>