package org.gimmesomepeace.zzzcompanion.data.memory.speciality

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityFilters
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityWriterRepository
import org.gimmesomepeace.zzzcompanion.data.memory.InMemoryRepository

private const val MAX_PAGE_SIZE = 100

class InMemorySpecialityRepository :
    InMemoryRepository<SpecialityId, Speciality, SpecialityFilters>({ it.id }, Speciality::class, PageSize(MAX_PAGE_SIZE)),
    SpecialityReaderRepository,
    SpecialityWriterRepository
