package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import kotlinx.coroutines.flow.Flow


interface CharacterLocalDataSource {
    fun getAll() : Flow<List<CharacterLocalEntity>>
}