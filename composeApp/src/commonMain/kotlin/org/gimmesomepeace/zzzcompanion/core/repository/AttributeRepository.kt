package org.gimmesomepeace.zzzcompanion.core.repository

import kotlinx.coroutines.flow.Flow
import org.gimmesomepeace.zzzcompanion.core.model.Attribute


interface AttributeRepository {
    fun getAll(): Flow<List<Attribute>>
}