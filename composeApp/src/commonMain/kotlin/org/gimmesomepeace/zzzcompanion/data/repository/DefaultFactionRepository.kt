package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.data.storage.local.faction.FactionLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.faction.toDomain
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.repository.FactionRepository


class DefaultFactionRepository(
    private val factionLocalDataSource: FactionLocalDataSource,
) : FactionRepository {
    override fun getAll(): Flow<List<Faction>> {
        return factionLocalDataSource.getAll().map { it.toDomain() }
    }
}
