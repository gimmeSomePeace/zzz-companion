package org.zzzcompanion.features.characters.data.uiModels

import org.zzzcompanion.features.characters.data.entities.Attribute
import org.zzzcompanion.features.characters.data.entities.Faction
import org.zzzcompanion.features.characters.data.entities.Rarity
import org.zzzcompanion.features.characters.data.entities.Speciality


data class CharactersFilterDetails(
    val query: String = "",
    val faction: Faction? = null,
    val attribute: Attribute? = null,
    val speciality: Speciality? = null,
    val rarity: Rarity? = null
)
