package org.gimmesomepeace.zzzcompanion.app.features.browser.filter

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import kotlin.collections.get


fun FiltersStateUi.from(
    filters: CharacterFilters,
    factionsById: Map<FactionId, Faction>,
    attributesById: Map<AttributeId, Attribute>,
    specialitiesById: Map<SpecialityId, Speciality>,
): FiltersStateUi {
    val faction = factionsById[filters.factionId]
    val attribute = attributesById[filters.attributeId]
    val speciality = specialitiesById[filters.specialityId]

    return FiltersStateUi(
        query = query,
        faction = faction,
        attribute = attribute,
        rarity = rarity,
        speciality = speciality
    )
}
