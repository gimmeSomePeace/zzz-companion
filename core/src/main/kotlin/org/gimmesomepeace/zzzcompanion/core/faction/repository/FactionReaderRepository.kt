package org.gimmesomepeace.zzzcompanion.core.faction.repository

import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionFilters
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface FactionReaderRepository:
    ReaderRepository<Faction, FactionId>,
    PaginationRepository<Faction, FactionFilters>