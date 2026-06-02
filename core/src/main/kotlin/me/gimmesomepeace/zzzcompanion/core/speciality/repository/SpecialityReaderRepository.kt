package me.gimmesomepeace.zzzcompanion.core.speciality.repository

import me.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository
import me.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityFilters
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

interface SpecialityReaderRepository:
    ReaderRepository<Speciality, SpecialityId>,
    PaginationRepository<Speciality, SpecialityFilters>