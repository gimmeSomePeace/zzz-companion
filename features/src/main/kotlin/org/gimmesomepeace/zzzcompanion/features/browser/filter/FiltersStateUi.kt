package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality

data class FiltersStateUi(
    val query: String = "",
    val faction: Faction? = null,
    val attribute: Attribute? = null,
    val speciality: Speciality? = null,
    val rarity: Rarity? = null,
)
