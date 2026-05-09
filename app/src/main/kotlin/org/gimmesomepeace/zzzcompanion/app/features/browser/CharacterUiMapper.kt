package org.gimmesomepeace.zzzcompanion.app.features.browser

import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItemUi
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId


fun CharacterListItem.toUi(
    factionById: Map<FactionId, Faction>,
    attributesById: Map<AttributeId, Attribute>,
    specialitiesById: Map<SpecialityId, Speciality>,
    ) : CharacterListItemUi {
    val faction = factionById.getValue(factionId)
    val speciality = requireNotNull(specialitiesById[specialityId])
    val attribute = requireNotNull(attributesById[attributeId])

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
