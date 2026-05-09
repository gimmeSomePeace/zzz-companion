package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

data class ReferenceData(
    val factions: List<Faction> = emptyList(),
    val attributes: List<Attribute> = emptyList(),
    val specialities: List<Speciality> = emptyList(),
    val rarities: List<Rarity> = emptyList(),

    val factionsById: Map<FactionId, Faction> = mapOf(),
    val attributesById: Map<AttributeId, Attribute> = mapOf(),
    val specialitiesById: Map<SpecialityId, Speciality> = mapOf(),
)