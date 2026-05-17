package org.gimmesomepeace.zzzcompanion.features.browser

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItemUi

internal fun CharacterListItem.toUi(
    factionById: Map<FactionId, Faction>,
    attributesById: Map<AttributeId, Attribute>,
    specialitiesById: Map<SpecialityId, Speciality>,
): CharacterListItemUi {
    val faction = requireNotNull(factionById[factionId]) { "Unknown character faction: $factionId" }
    val speciality = requireNotNull(specialitiesById[specialityId]) { "Unknown character speciality: $specialityId" }
    val attribute = requireNotNull(attributesById[attributeId]) { "Unknown character attribute: $attributeId" }

    return CharacterListItemUi(
        id = id,
        name = name,
        imageUrl = imageUrl,

        faction = faction,
        rarity = rarity,
        speciality = speciality,
        attribute = attribute,
        isOwned = isOwned
    )
}
