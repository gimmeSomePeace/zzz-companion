package org.gimmesomepeace.zzzcompanion.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterContext
import org.gimmesomepeace.zzzcompanion.domain.repository.CharacterRepository
import org.gimmesomepeace.zzzcompanion.domain.repository.OwnedCharacterRepository


class GetCharacterContextsUseCase(
    private val characterRepository: CharacterRepository,
    private val ownedCharactersRepository: OwnedCharacterRepository
) {
    fun execute(): Flow<List<CharacterContext>> {
        return combine(
            characterRepository.getAll(),
            ownedCharactersRepository.getAll()
        ) { characters, owned ->
            characters.map { character ->
                CharacterContext(
                    character = character,
                    ownership = owned.find { it.characterId == character.id }
                )
            }
        }
    }
}