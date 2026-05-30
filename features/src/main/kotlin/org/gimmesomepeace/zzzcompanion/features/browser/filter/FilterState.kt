package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity

data class FilterState(
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
