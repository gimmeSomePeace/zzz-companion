package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.RarityId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import kotlin.collections.get


fun CharacterFilters.toUi(
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
