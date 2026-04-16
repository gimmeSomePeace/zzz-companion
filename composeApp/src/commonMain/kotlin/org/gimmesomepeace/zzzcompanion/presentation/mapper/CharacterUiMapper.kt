package org.gimmesomepeace.zzzcompanion.presentation.mapper

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterContext
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId
import org.gimmesomepeace.zzzcompanion.presentation.model.character.CharacterUi


fun CharacterContext.toUi(
        factionById: Map<FactionId, Faction>,
        raritiesById: Map<RarityId, Rarity>,
        attributesById: Map<AttributeId, Attribute>,
        specialitiesById: Map<SpecialityId, Speciality>,
    ) : CharacterUi {
    val faction = requireNotNull(factionById[character.factionId])
    val rarity = requireNotNull(raritiesById[character.rarityId])
    val speciality = requireNotNull(specialitiesById[character.specialityId])
    val attribute = requireNotNull(attributesById[character.attributeId])

    return CharacterUi(
            id = character.id,
            name = character.name,
            imageUrl = character.imageUrl,

            faction = faction,
            rarity = rarity,
            speciality = speciality,
            attribute = attribute,
            isOwned = (ownership != null)
    )
}

fun List<CharacterContext>.toUi(
    factionById: Map<FactionId, Faction>,
    raritiesById: Map<RarityId, Rarity>,
    attributesById: Map<AttributeId, Attribute>,
    specialitiesById: Map<SpecialityId, Speciality>,
): List<CharacterUi> = this.map { it.toUi(
    factionById = factionById,
    raritiesById = raritiesById,
    specialitiesById = specialitiesById,
    attributesById = attributesById
)}
