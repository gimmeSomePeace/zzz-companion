package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId


data class Attribute(
    val id: AttributeId,
    val name: String,
    val imageUrl: String
)
