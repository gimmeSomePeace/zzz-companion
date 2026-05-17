package org.gimmesomepeace.zzzcompanion.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.AddCharacterUserDataResult
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks

class AddCharacterToOwnedUseCase(
    private val characterUserDataRepository: CharacterUserDataRepository,
) {
    operator fun invoke(characterId: CharacterId): AddCharacterUserDataResult {
        return characterUserDataRepository.addIfNotExists(
            CharacterUserData.create(
                id = characterId,
                EquippedDisks.create()
            )
        )
    }
}
