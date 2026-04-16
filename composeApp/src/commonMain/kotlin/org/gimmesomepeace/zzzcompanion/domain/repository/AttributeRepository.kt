package org.gimmesomepeace.zzzcompanion.domain.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute


interface AttributeRepository {
    fun getAll(): Flow<List<Attribute>>
}