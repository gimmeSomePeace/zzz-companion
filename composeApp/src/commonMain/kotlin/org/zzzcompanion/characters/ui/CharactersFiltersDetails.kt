package org.zzzcompanion.characters.ui

import org.zzzcompanion.characters.model.Attribute
import org.zzzcompanion.characters.model.Faction
import org.zzzcompanion.characters.model.Rarity
import org.zzzcompanion.characters.model.Speciality


data class CharactersFilterDetails(
    val query: String = "",
    val faction: Faction? = null,
    val attribute: Attribute? = null,
    val speciality: Speciality? = null,
    val rarity: Rarity? = null
)
