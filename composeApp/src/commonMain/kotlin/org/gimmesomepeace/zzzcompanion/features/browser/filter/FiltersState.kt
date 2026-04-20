package org.gimmesomepeace.zzzcompanion.features.browser.filter

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


data class FiltersState(
    val query: String = "",
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarityId: RarityId? = null
)