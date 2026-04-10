package org.zzzcompanion.features.characters.mappers

import org.zzzcompanion.features.characters.data.entities.Character
import org.zzzcompanion.features.characters.data.entities.UserCharacter
import org.zzzcompanion.features.characters.data.repository.ReferenceData
import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails


fun Character.toUi(refs: ReferenceData) : CharacterDetails {
    val faction = refs.factions.find { it.id == factionId }
    val attribute = refs.attributes.find { it.id == attributeId }
    val speciality = refs.specialities.find { it.id == specialityId }
    val rarity = refs.rarities.find { it.id == rarityId }

    return CharacterDetails(
        id = id,
        name = name,
        imageUrl = imageUrl,

        faction = faction,
        attribute = attribute,
        speciality = speciality,
        rarity = rarity,
    )
}

fun UserCharacter.toUi(refs: ReferenceData): UserCharacterDetails {
    val character = refs.characters.find { it.id == characterId }

    return UserCharacterDetails(
        id = id,
        character = character?.toUi(refs),
        disks = disks
    )
}
