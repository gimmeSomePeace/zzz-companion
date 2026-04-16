package org.gimmesomepeace.zzzcompanion.domain.usecase

import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.OwnedCharacter
import org.gimmesomepeace.zzzcompanion.domain.model.character.OwnedCharacterId
import org.gimmesomepeace.zzzcompanion.domain.repository.OwnedCharacterRepository
import org.gimmesomepeace.zzzcompanion.domain.util.IdGenerator


class AddCharacterToOwnedUseCase(
    private val ownedCharacterRepository: OwnedCharacterRepository,
    private val idGenerator: IdGenerator
) {
    fun execute(characterId: CharacterId) : Boolean {
        return ownedCharacterRepository.addIfNotExists(OwnedCharacter(
            id = OwnedCharacterId(idGenerator.generateId()),
            characterId = characterId,
            disks = List(6) { "-1" }
        ))
    }
}