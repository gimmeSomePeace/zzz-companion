package org.zzzcompanion.features.characters.domain

import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails

data class CharactersFilters(
    val query: String = "",
    val factionId: Long? = null,
    val attributeId: Long? = null,
    val specialityId: Long? = null,
    val rarityId: Long? = null
) {
    fun isOk(c: CharacterDetails): Boolean {
        return (query.isBlank() || c.name.contains(query, ignoreCase = true)) &&
        (factionId == null || c.faction?.id == factionId) &&
        (attributeId == null || c.attribute?.id == attributeId) &&
        (specialityId == null || c.speciality?.id == specialityId) &&
        (rarityId == null || c.rarity?.id == rarityId)
    }

    fun isOk(c: UserCharacterDetails): Boolean {
        return if (c.character != null) isOk(c.character) else false
    }
}