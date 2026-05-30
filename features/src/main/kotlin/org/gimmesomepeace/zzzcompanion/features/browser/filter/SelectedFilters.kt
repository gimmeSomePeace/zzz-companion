package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity

internal data class SelectedFilters(
    val query: String = "",
    val faction: FactionId? = null,
    val attribute: AttributeId? = null,
    val speciality: SpecialityId? = null,
    val rarity: Rarity? = null,
)
