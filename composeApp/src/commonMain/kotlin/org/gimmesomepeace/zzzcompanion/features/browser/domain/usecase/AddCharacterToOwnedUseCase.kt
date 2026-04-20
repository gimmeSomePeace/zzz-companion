package org.gimmesomepeace.zzzcompanion.features.browser.domain.usecase

import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.features.browser.repository.CharacterRepository


class AddCharacterToOwnedUseCase(
    private val characterRepository: CharacterRepository
) {
    fun execute(characterId: CharacterId) {
        return characterRepository.setOwned(characterId, true)
    }
}