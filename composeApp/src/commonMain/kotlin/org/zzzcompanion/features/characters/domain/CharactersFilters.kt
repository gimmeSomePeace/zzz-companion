package org.zzzcompanion.features.characters.domain

import org.zzzcompanion.features.characters.data.entities.AttributeId
import org.zzzcompanion.features.characters.data.entities.Character
import org.zzzcompanion.features.characters.data.entities.FactionId
import org.zzzcompanion.features.characters.data.entities.RarityId
import org.zzzcompanion.features.characters.data.entities.SpecialityId
import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails

data class CharactersFilters(
    val query: String = "",
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarityId: RarityId? = null
) {
    fun isOk(c: Character): Boolean {
        return (query.isBlank() || c.name.contains(query, ignoreCase = true)) &&
        (factionId == null || c.factionId == factionId) &&
        (attributeId == null || c.attributeId == attributeId) &&
        (specialityId == null || c.specialityId == specialityId) &&
        (rarityId == null || c.rarityId == rarityId)
    }
}