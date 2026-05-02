package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction


interface FactionRepository {
    fun getAll() : Flow<List<Faction>>
}