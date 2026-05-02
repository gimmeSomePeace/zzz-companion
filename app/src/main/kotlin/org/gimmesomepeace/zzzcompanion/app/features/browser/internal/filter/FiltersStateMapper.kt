package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter

import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction
import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId
import kotlin.collections.get


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
