package org.zzzcompanion.features.characters.mappers

import org.zzzcompanion.features.characters.data.repository.ReferenceData
import org.zzzcompanion.features.characters.data.uiModels.CharactersFilterDetails
import org.zzzcompanion.features.characters.domain.CharactersFilters


fun CharactersFilters.toUi(refs: ReferenceData): CharactersFilterDetails  {
    val faction = refs.factions.find { it.id == factionId }
    val attribute = refs.attributes.find { it.id == attributeId }
    val speciality = refs.specialities.find { it.id == specialityId }
    val rarity = refs.rarities.find { it.id == rarityId }

    return CharactersFilterDetails(
        query,
        faction,
        attribute,
        speciality,
        rarity,
    )
}
