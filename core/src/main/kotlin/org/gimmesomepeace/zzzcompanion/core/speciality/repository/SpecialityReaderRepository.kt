package org.gimmesomepeace.zzzcompanion.core.speciality.repository

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityFilters
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

interface SpecialityReaderRepository:
    ReaderRepository<Speciality, SpecialityId>,
    PaginationRepository<Speciality, SpecialityFilters>