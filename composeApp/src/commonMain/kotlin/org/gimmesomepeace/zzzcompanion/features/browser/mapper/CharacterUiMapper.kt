package org.gimmesomepeace.zzzcompanion.features.browser.mapper

import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.model.CharacterListItemUi


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
