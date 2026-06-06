package me.gimmesomepeace.zzzcompanion.filters.model

import me.gimmesomepeace.uikit.select.SelectOption
import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

internal data class FilterState(
    val query: String? = null,
    val factions: List<SelectOption<FactionId>> = emptyList(),
    val attributes: List<SelectOption<AttributeId>> = emptyList(),
    val specialities: List<SelectOption<SpecialityId>> = emptyList(),
    val rarities: List<SelectOption<Rarity>> = emptyList(),
    val selectedFaction: SelectOption<FactionId> = SelectOption.All,
    val selectedAttribute: SelectOption<AttributeId> = SelectOption.All,
    val selectedSpeciality: SelectOption<SpecialityId> = SelectOption.All,
    val selectedRarity: SelectOption<Rarity> = SelectOption.All,
)
