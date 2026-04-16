package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.data.storage.local.rarity.toDomain
import org.gimmesomepeace.zzzcompanion.data.storage.local.rarity.RarityLocalDataSource
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.repository.RarityRepository


class DefaultRarityRepository(
    private val localDataSource: RarityLocalDataSource,
) : RarityRepository {
    override fun getAll(): Flow<List<Rarity>> {
        return localDataSource.getAll().map { it.toDomain() }
    }
}