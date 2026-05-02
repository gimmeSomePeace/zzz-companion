package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity


interface RarityRepository {
    fun getAll(): Flow<List<Rarity>>
}