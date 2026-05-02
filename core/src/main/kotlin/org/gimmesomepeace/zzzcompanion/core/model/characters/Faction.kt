package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import java.net.URI


data class Faction (
    val id: FactionId,
    val name: String,
    val imageUrl: URI
)
