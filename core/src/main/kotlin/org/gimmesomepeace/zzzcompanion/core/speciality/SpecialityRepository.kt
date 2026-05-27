package org.gimmesomepeace.zzzcompanion.core.speciality

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface SpecialityRepository:
    ReaderRepository<Speciality, SpecialityId>,
    PaginationRepository<Speciality, SpecialityFilters>
