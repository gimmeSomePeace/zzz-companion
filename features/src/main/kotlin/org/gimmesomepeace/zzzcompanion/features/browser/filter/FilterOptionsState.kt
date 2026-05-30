package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

data class FilterOptionsState(
    val factions: List<SelectOption<FactionId>> = emptyList(),
    val attributes: List<SelectOption<AttributeId>> = emptyList(),
    val specialities: List<SelectOption<SpecialityId>> = emptyList(),
    val rarities: List<SelectOption<Rarity>> = emptyList(),
)
