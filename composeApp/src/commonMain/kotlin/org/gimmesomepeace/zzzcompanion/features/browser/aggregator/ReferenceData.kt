package org.gimmesomepeace.zzzcompanion.features.browser.aggregator

import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


data class ReferenceData(
    val factions: List<Faction> = emptyList(),
    val attributes: List<Attribute> = emptyList(),
    val specialities: List<Speciality> = emptyList(),
    val rarities: List<Rarity> = emptyList(),

    val factionsById: Map<FactionId, Faction> = mapOf(),
    val raritiesById: Map<RarityId, Rarity> = mapOf(),
    val attributesById: Map<AttributeId, Attribute> = mapOf(),
    val specialitiesById: Map<SpecialityId, Speciality> = mapOf(),
)
