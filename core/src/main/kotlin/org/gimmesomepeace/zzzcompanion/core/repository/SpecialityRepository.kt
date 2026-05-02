package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.Speciality


interface SpecialityRepository {
    fun getAll() : Flow<List<Speciality>>
}