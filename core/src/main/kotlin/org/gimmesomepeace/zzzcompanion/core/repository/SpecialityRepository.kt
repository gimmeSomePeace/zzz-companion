package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality


interface SpecialityRepository {
    fun getAll() : List<Speciality>
}