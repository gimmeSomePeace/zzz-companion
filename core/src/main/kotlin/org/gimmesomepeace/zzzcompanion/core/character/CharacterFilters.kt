package org.gimmesomepeace.zzzcompanion.core.character

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.RarityId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

/**
 * Набор фильтров при пагинации персонажей.
 */
data class CharacterFilters(
    val query: String = "",
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarityId: RarityId? = null
)