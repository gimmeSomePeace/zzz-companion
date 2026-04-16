package org.gimmesomepeace.zzzcompanion.domain.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction


interface FactionRepository {
    fun getAll() : Flow<List<Faction>>
}