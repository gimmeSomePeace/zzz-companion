package me.gimmesomepeace.zzzcompanion.browser.usecase

import me.gimmesomepeace.zzzcompanion.catalog.CharacterCatalogItem
import me.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import me.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import me.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import me.gimmesomepeace.zzzcompanion.core.characteruserdata.CharacterUserDataRepository
import me.gimmesomepeace.zzzcompanion.core.faction.repository.FactionReaderRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import me.gimmesomepeace.zzzcompanion.core.speciality.repository.SpecialityReaderRepository

internal class GetCharactersPageUseCase(
    private val characterRepository: CharacterReaderRepository,
    private val factionRepository: FactionReaderRepository,
    private val attributeRepository: AttributeReaderRepository,
    private val specialityRepository: SpecialityReaderRepository,
    private val characterUserDataRepository: CharacterUserDataRepository,
) {
    suspend operator fun invoke(cursor: String?, pageSize: PageSize, filters: CharacterFilters): Page<CharacterCatalogItem> {
        val page = characterRepository.getPage(pageSize, cursor, filters)
        val userDataMap = characterUserDataRepository.findByIds(page.items.map { it.id })

        val items = page.items.map {
            CharacterCatalogItem(
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
