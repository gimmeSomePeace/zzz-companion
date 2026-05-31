package org.gimmesomepeace.zzzcompanion.features.browser.usecase

import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import org.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem

internal class GetCharactersPageUseCase(
    private val characterRepository: CharacterReaderRepository,
    private val factionRepository: FactionReaderRepository,
    private val attributeRepository: AttributeReaderRepository,
    private val specialityRepository: SpecialityReaderRepository,
    private val characterUserDataRepository: CharacterUserDataRepository,
) {
    suspend operator fun invoke(cursor: String?, pageSize: PageSize, filters: CharacterFilters): Page<CharacterListItem> {
        val page = characterRepository.getPage(pageSize, cursor, filters)
        val userDataMap = characterUserDataRepository.findByIds(page.items.map { it.id })

        val items = page.items.map {
            CharacterListItem(
                id = it.id,
                name = it.name,
                faction = factionRepository.get(it.factionId),
                attribute = attributeRepository.get(it.attributeId),
                speciality = specialityRepository.get(it.specialityId),
                rarity = it.rarity,
                imageUrl = it.imageUri,

                isOwned = userDataMap.containsKey(it.id)
            )
        }
        return Page(items, page.nextCursor)
    }
}
