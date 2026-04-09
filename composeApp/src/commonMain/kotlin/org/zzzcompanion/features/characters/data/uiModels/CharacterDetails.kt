package org.zzzcompanion.features.characters.data.uiModels

import org.zzzcompanion.features.characters.data.entities.Attribute
import org.zzzcompanion.features.characters.data.entities.Faction
import org.zzzcompanion.features.characters.data.entities.Rarity
import org.zzzcompanion.features.characters.data.entities.Speciality

data class CharacterDetails(
    val id: Long,
    val name: String,

    val faction: Faction?,
    val attribute: Attribute?,
    val speciality: Speciality?,
    val rarity: Rarity?,

    val imageUrl: String,
)
