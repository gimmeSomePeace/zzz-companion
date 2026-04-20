package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId


data class Faction (
    val id: FactionId,
    val name: String,
    val imageUrl: String
)
