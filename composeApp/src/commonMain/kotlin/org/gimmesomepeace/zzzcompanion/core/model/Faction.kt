package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import java.net.URI


data class Faction (
    val id: FactionId,
    val name: String,
    val imageUrl: URI
)
