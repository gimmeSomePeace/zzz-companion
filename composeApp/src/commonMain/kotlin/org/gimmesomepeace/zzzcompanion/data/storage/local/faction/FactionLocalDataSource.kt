package org.gimmesomepeace.zzzcompanion.data.storage.local.faction

import kotlinx.coroutines.flow.Flow


interface FactionLocalDataSource {
    fun getAll(): Flow<List<FactionLocalEntity>>
}