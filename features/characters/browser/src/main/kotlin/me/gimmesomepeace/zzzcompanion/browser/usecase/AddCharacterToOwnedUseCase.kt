package me.gimmesomepeace.zzzcompanion.browser.usecase

import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserData
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.EquippedDisks

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
