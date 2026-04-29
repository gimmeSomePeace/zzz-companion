package org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FakeCharacterUserDataLocalDataSource : CharacterUserDataDataSource {
    private val ownedCharacters = MutableStateFlow(
        listOf(
            CharacterUserDataLocalEntity(
                "1",
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
    )

    override fun getAll(): Flow<List<CharacterUserDataLocalEntity>> {
        return ownedCharacters.asStateFlow()
    }

    override fun getById(id: String): CharacterUserDataLocalEntity? {
        return ownedCharacters.value.firstOrNull { it.id == id}
    }

    override fun existsById(id: String): Boolean {
        return ownedCharacters.value.any { it.id == id }
    }

    override fun insert(character: CharacterUserDataLocalEntity) {
        ownedCharacters.value = ownedCharacters.value.plus(character)
    }
}