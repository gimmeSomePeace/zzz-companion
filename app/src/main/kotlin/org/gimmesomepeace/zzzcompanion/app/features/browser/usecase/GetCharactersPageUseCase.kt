package org.gimmesomepeace.zzzcompanion.app.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterRepository
import org.gimmesomepeace.zzzcompanion.core.repository.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.repository.Page


class GetCharactersPageUseCase(
    private val characterRepository: CharacterRepository,
    private val characterUserDataRepository: CharacterUserDataRepository
) {
    fun execute(cursor: String?, limit: Int, filters: CharacterFilters): Page<CharacterListItem> {
        // TODO: Получать разом все id это долго. Переделать на join
        val userData = characterUserDataRepository.getAll()

        val page = characterRepository.getPage(cursor, limit, filters)

        val items = page.items.map {
            CharacterListItem(
                id = it.id,
                name = it.name,
                factionId = it.factionId,
                attributeId = it.attributeId,
                specialityId = it.specialityId,
                rarityId = it.rarityId,
                imageUrl = it.imageUrl,

                isOwned = userData.any { data -> it.id == data.id },
            )
        }
        return Page(items, page.nextCursor)
    }
}