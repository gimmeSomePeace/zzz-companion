package org.gimmesomepeace.zzzcompanion.app.features.browser

import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItemUi
import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction
import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId


fun CharacterListItem.toUi(
    factionById: Map<FactionId, Faction>,
    raritiesById: Map<RarityId, Rarity>,
    attributesById: Map<AttributeId, Attribute>,
    specialitiesById: Map<SpecialityId, Speciality>,
    ) : CharacterListItemUi {
    val faction = factionById.getValue(factionId)
    val rarity = requireNotNull(raritiesById[rarityId])
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

fun List<CharacterListItem>.toUi(
    factionById: Map<FactionId, Faction>,
    raritiesById: Map<RarityId, Rarity>,
    attributesById: Map<AttributeId, Attribute>,
    specialitiesById: Map<SpecialityId, Speciality>,
): List<CharacterListItemUi> = this.map { it.toUi(
    factionById = factionById,
    raritiesById = raritiesById,
    specialitiesById = specialitiesById,
    attributesById = attributesById
)}
