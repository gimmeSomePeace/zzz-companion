package org.gimmesomepeace.zzzcompanion.features.browser.domain.usecase

import org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterUserDataId
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.util.IdGenerator


class AddCharacterToOwnedUseCase(
    private val characterUserDataRepository: CharacterUserDataRepository,
    private val idGenerator: IdGenerator,
) {
    fun execute(characterId: CharacterId) {
        characterUserDataRepository.addIfNotExistsByCharacterId(CharacterUserData(
            id = CharacterUserDataId(idGenerator.generateId()),
            characterId = characterId,
            disks = emptyList(),
        ))
    }
}