package org.zzzcompanion.features.characters.domain

import org.zzzcompanion.features.characters.data.entities.Character
import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails

data class CharactersFilters(
    val query: String = "",
    val factionId: Long? = null,
    val attributeId: Long? = null,
    val specialityId: Long? = null,
    val rarityId: Long? = null
) {
    fun isOk(c: Character): Boolean {
        return (query.isBlank() || c.name.contains(query, ignoreCase = true)) &&
        (factionId == null || c.factionId == factionId) &&
        (attributeId == null || c.attributeId == attributeId) &&
        (specialityId == null || c.specialityId == specialityId) &&
        (rarityId == null || c.rarityId == rarityId)
    }
}