package org.gimmesomepeace.zzzcompanion.domain.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality


interface SpecialityRepository {
    fun getAll() : Flow<List<Speciality>>
}