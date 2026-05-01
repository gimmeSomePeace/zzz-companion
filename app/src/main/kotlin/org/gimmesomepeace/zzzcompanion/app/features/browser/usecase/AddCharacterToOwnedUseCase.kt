package org.gimmesomepeace.zzzcompanion.app.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository


class AddCharacterToOwnedUseCase(
    private val characterUserDataRepository: CharacterUserDataRepository,
) {
    fun execute(characterId: CharacterId) {
        characterUserDataRepository.addIfNotExists(
            CharacterUserData(
                id = characterId,
                disks = emptyList(),
            )
        )
    }
}