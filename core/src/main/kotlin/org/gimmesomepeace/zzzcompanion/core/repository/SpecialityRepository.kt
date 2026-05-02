package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality


interface SpecialityRepository {
    fun getAll() : Flow<List<Speciality>>
}