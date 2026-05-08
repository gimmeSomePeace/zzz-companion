package org.gimmesomepeace.zzzcompanion.app.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.character.CharacterRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize


class GetCharactersPageUseCase(
    private val characterRepository: CharacterRepository,
    private val characterUserDataRepository: CharacterUserDataRepository
) {
    fun execute(cursor: String?, pageSize: PageSize, filters: CharacterFilters): Page<CharacterListItem> {
        val page = characterRepository.getPage(cursor, pageSize, filters)
        val userDataMap = characterUserDataRepository.getByIds(page.items.map { it.id })

        val items = page.items.map {
            CharacterListItem(
                id = it.id,
                name = it.name,
                factionId = it.factionId,
                attributeId = it.attributeId,
                specialityId = it.specialityId,
                rarityId = it.rarityId,
                imageUrl = it.imageUrl,

                isOwned = userDataMap.containsKey(it.id)
            )
        }
        return Page(items, page.nextCursor)
    }
}