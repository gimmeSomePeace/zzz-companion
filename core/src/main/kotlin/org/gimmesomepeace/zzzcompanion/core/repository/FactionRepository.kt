package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.Faction


interface FactionRepository {
    fun getAll() : Flow<List<Faction>>
}