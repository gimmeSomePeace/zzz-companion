package org.gimmesomepeace.zzzcompanion.features.characters.domain

import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId


data class CharactersFilters(
    val query: String = "",
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarityId: RarityId? = null
)
