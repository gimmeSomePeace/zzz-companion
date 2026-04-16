package org.gimmesomepeace.zzzcompanion.domain.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity


interface RarityRepository {
    fun getAll(): Flow<List<Rarity>>
}