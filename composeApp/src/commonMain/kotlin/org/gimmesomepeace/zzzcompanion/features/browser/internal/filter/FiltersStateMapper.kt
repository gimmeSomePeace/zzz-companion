package org.gimmesomepeace.zzzcompanion.features.browser.internal.filter

import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


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
