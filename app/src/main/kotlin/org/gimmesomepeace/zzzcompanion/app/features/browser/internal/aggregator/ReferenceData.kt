package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator

import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction
import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId


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
