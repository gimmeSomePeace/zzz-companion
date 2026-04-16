package org.gimmesomepeace.zzzcompanion.data.storage.local.attribute

import kotlinx.coroutines.flow.Flow


interface AttributeLocalDataSource {
    fun getAll(): Flow<List<AttributeLocalEntity>>
}
