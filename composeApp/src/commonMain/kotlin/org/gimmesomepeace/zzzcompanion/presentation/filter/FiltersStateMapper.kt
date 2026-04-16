package org.gimmesomepeace.zzzcompanion.presentation.filter

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId


fun FiltersState.toUi(
    factionsById: Map<FactionId, Faction>,
    attributesById: Map<AttributeId, Attribute>,
    raritiesById: Map<RarityId, Rarity>,
    specialitiesById: Map<SpecialityId, Speciality>,
) : FiltersStateUi {
    val faction = factionsById.getOrDefault(factionId, null)
    val attribute = attributesById.getOrDefault(attributeId, null)
    val rarity = raritiesById.getOrDefault(rarityId, null)
    val speciality = specialitiesById.getOrDefault(specialityId, null)

    return FiltersStateUi(
        query = query,
        faction = faction,
        attribute = attribute,
        rarity = rarity,
        speciality = speciality
    )
}
