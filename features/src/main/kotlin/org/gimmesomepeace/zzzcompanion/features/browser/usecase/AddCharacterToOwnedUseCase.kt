package org.gimmesomepeace.zzzcompanion.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks

internal class AddCharacterToOwnedUseCase(
    private val characterUserDataRepository: CharacterUserDataRepository,
) {
    suspend operator fun invoke(characterId: CharacterId) {
        characterUserDataRepository.create(
            CharacterUserData.create(
                id = characterId,
                EquippedDisks.create()
            )
        )
    }
}
