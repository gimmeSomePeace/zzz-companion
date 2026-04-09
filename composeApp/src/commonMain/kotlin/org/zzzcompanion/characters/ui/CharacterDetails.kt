package org.zzzcompanion.characters.ui

import org.zzzcompanion.characters.model.Attribute
import org.zzzcompanion.characters.model.Faction
import org.zzzcompanion.characters.model.Rarity
import org.zzzcompanion.characters.model.Speciality

data class CharacterDetails(
    val id: Long,
    val name: String,

    val faction: Faction?,
    val attribute: Attribute?,
    val speciality: Speciality?,
    val rarity: Rarity?,

    val imageUrl: String,
)
