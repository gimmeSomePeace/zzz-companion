package org.zzzcompanion.characters.domain.usecase

import org.zzzcompanion.characters.repository.CharacterRepository
import org.zzzcompanion.characters.repository.UserCharacterRepository

class GetCharactersStateUseCase (
    private val characterRepository: CharacterRepository,
    private val userCharacterRepository: UserCharacterRepository
) {
    suspend fun execute(): CharactersState {
        val allCharacters = characterRepository.getAll()
        val userCharacters = userCharacterRepository.getAll()

        val ownedIds = userCharacters.map { it.characterId }
        val owned = allCharacters.filter { it.id in ownedIds }
        val missing = allCharacters.filter { it.id !in ownedIds }

        return CharactersState(
            owned = owned,
            missing = missing
        )
    }
}