package org.gimmesomepeace.zzzcompanion.features.browser.domain.usecase

import kotlinx.coroutines.flow.Flow

import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.features.browser.repository.CharacterRepository


class GetCharacterContextsUseCase(
    private val characterRepository: CharacterRepository
) {
    fun execute(): Flow<List<CharacterListItem>> {
        return characterRepository.getAll()
    }
}