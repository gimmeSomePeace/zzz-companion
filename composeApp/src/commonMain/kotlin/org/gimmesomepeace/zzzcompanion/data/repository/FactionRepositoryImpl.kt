package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.data.storage.local.faction.FactionLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.faction.toDomain
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.repository.FactionRepository


class FactionRepositoryImpl(
    private val factionLocalDataSource: FactionLocalDataSource,
) : FactionRepository {
    override fun getAll(): Flow<List<Faction>> {
        return factionLocalDataSource.getAll().map { it.toDomain() }
    }
}
