package org.gimmesomepeace.zzzcompanion.aggregator

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId


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
