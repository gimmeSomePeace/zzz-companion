package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId


data class Rarity(
    val id: RarityId,
    val name: String,
    val imageUrl: String
)
