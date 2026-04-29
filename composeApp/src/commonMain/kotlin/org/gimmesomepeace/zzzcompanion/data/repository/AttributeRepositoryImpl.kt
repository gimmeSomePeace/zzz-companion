package org.gimmesomepeace.zzzcompanion.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.gimmesomepeace.zzzcompanion.data.storage.local.attribute.AttributeLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.attribute.toDomain
import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.repository.AttributeRepository


class AttributeRepositoryImpl(
    private val localDataSource: AttributeLocalDataSource
) : AttributeRepository {
    override fun getAll(): Flow<List<Attribute>> {
        return localDataSource.getAll().map { it.toDomain() }
    }
}