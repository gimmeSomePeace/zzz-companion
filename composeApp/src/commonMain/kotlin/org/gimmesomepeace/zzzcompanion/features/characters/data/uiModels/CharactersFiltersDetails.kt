package org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels

import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Rarity
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality


data class CharactersFilterDetails(
    val query: String = "",
    val faction: Faction? = null,
    val attribute: Attribute? = null,
    val speciality: Speciality? = null,
    val rarity: Rarity? = null
)
