package me.gimmesomepeace.zzzcompanion.filters

import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

internal sealed interface FiltersIntent {
    data class SetQuery(val query: String) : FiltersIntent
    data class SetFaction(val factionId: FactionId?) : FiltersIntent
    data class SetSpeciality(val specialityId: SpecialityId?) : FiltersIntent
    data class SetAttribute(val attributeId: AttributeId?) : FiltersIntent
    data class SetRarity(val rarity: Rarity?) : FiltersIntent
}
