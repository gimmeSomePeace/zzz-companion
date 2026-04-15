package org.gimmesomepeace.zzzcompanion.features.characters.data.entities


@JvmInline
value class AttributeId(val value: String)

data class Attribute(
    val id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId,
    val name: String,
    val imageUrl: String
)
