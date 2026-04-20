package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.Speciality


data class FiltersStateUi(
    val query: String = "",
    val faction: Faction? = null,
    val attribute: Attribute? = null,
    val speciality: Speciality? = null,
    val rarity: Rarity? = null
)
