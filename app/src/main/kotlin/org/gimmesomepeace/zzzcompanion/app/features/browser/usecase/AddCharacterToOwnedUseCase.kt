package org.gimmesomepeace.zzzcompanion.app.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository


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