package org.gimmesomepeace.zzzcompanion.core.faction

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface FactionRepository:
    ReaderRepository<Faction, FactionId>,
    PaginationRepository<Faction, FactionFilters>
