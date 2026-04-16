package org.gimmesomepeace.zzzcompanion.presentation.filter

import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId

data class FiltersState(
    val query: String = "",
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarityId: RarityId? = null
)