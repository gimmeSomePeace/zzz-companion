package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter

import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction
import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality


data class FiltersStateUi(
    val query: String = "",
    val faction: Faction? = null,
    val attribute: Attribute? = null,
    val speciality: Speciality? = null,
    val rarity: Rarity? = null
)
