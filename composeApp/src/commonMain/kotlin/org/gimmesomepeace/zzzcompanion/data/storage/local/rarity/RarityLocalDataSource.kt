package org.gimmesomepeace.zzzcompanion.data.storage.local.rarity

import kotlinx.coroutines.flow.Flow


interface RarityLocalDataSource {
    fun getAll(): Flow<List<RarityLocalEntity>>
}
