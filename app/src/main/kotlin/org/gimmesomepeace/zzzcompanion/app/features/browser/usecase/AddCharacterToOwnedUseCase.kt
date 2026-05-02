package org.gimmesomepeace.zzzcompanion.app.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.repository.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository


class AddCharacterToOwnedUseCase(
    private val characterUserDataRepository: CharacterUserDataRepository,
) {
    fun execute(characterId: CharacterId): AddCharacterUserDataResult {
        return characterUserDataRepository.addIfNotExists(
            CharacterUserData(
                id = characterId
            )
        )
    }
}