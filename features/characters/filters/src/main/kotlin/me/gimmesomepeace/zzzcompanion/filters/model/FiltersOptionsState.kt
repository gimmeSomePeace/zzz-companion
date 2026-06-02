package me.gimmesomepeace.zzzcompanion.filters.model

import me.gimmesomepeace.uikit.select.SelectOption
import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

internal data class FiltersOptionsState(
    val factions: List<SelectOption<FactionId>> = emptyList(),
    val attributes: List<SelectOption<AttributeId>> = emptyList(),
    val specialities: List<SelectOption<SpecialityId>> = emptyList(),
    val rarities: List<SelectOption<Rarity>> = emptyList(),
)
