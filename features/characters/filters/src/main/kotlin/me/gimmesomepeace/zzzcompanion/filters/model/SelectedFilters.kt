package me.gimmesomepeace.zzzcompanion.filters.model

import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity

data class SelectedFilters(
    val query: String = "",
    val faction: FactionId? = null,
    val attribute: AttributeId? = null,
    val speciality: SpecialityId? = null,
    val rarity: Rarity? = null,
)
