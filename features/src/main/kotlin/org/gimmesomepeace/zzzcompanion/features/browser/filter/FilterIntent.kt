package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

sealed interface FilterIntent {
    data class SetQuery(val query: String) : FilterIntent
    data class SetFaction(val factionId: FactionId?) : FilterIntent
    data class SetSpeciality(val specialityId: SpecialityId?) : FilterIntent
    data class SetAttribute(val attributeId: AttributeId?) : FilterIntent
    data class SetRarity(val rarity: Rarity?) : FilterIntent
}
