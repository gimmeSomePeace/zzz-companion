package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import java.net.URI


data class Attribute(
    val id: AttributeId,
    val name: String,
    val imageUrl: URI
)
