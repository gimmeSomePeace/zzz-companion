package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.data.storage.local.speciality.SpecialityLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.speciality.toDomain
import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.repository.SpecialityRepository


class SpecialityRepositoryImpl(
    private val localDataSource: SpecialityLocalDataSource,
) : SpecialityRepository {
    override fun getAll(): Flow<List<Speciality>> {
        return localDataSource.getAll().map { it.toDomain() }
    }
}