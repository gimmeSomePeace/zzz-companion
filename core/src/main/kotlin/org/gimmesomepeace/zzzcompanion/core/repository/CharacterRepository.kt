package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.Character

interface CharacterRepository {
    fun getAll() : Flow<List<Character>>
}