package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import java.net.URI


data class Rarity(
    val id: RarityId,
    val name: String,
    val imageUrl: URI
)
