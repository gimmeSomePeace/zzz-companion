package org.gimmesomepeace.zzzcompanion.data.storage.local.speciality

import kotlinx.coroutines.flow.Flow


interface SpecialityLocalDataSource {
    fun getAll(): Flow<List<SpecialityLocalEntity>>
}
