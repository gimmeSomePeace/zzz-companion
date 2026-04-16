package org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FakeOwnedCharacterLocalDataSource : OwnedCharacterLocalDataSource {
    private val ownedCharacters = MutableStateFlow(
        listOf(
            OwnedCharacterLocalEntity(
                "1",
               "1",
                listOf("-1", "-1", "-1", "-1", "-1", "-1"),
            )
        )
    )

    override fun getAll(): Flow<List<OwnedCharacterLocalEntity>> {
        return ownedCharacters.asStateFlow()
    }

    override fun getByCharacterId(characterId: String): OwnedCharacterLocalEntity? {
        return ownedCharacters.value.firstOrNull { it.characterId == characterId}
    }

    override fun existsByCharacterId(characterId: String): Boolean {
        return ownedCharacters.value.any { it.characterId == characterId }
    }

    override fun insert(character: OwnedCharacterLocalEntity) {
        ownedCharacters.value = ownedCharacters.value.plus(character)
    }
}