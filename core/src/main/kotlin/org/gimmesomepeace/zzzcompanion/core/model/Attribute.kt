package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import java.net.URI


data class Attribute(
    val id: AttributeId,
    val name: String,
    val imageUrl: URI
)
