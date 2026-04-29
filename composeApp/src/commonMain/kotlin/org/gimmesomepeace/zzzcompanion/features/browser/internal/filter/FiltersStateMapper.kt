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
    val faction = factionsById[factionId]
    val attribute = attributesById[attributeId]
    val rarity = raritiesById[rarityId]
    val speciality = specialitiesById[specialityId]

    return FiltersStateUi(
        query = query,
        faction = faction,
        attribute = attribute,
        rarity = rarity,
        speciality = speciality
    )
}
