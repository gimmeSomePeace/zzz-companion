package org.gimmesomepeace.zzzcompanion.features.browser.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterRepository
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository


class GetCharacterContextsUseCase(
    private val characterRepository: CharacterRepository,
    private val characterUserDataRepository: CharacterUserDataRepository
) {
    fun execute(): Flow<List<CharacterListItem>> = combine(
        characterRepository.getAll(),
        characterUserDataRepository.getAll()
    ) {characters, userData ->
        characters.map {
            CharacterListItem(
                id = it.id,
                name = it.name,
                factionId = it.factionId,
                attributeId = it.attributeId,
                specialityId = it.specialityId,
                rarityId = it.rarityId,
                imageUrl = it.imageUrl,

                isOwned = userData.any { data -> it.id == data.characterId },
            )
        }
    }
}