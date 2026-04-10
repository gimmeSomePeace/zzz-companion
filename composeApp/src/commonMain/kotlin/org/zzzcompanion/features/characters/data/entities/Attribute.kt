package org.zzzcompanion.features.characters.data.entities


@JvmInline
value class AttributeId(val value: String)

data class Attribute(
    val id: AttributeId,
    val name: String,
    val imageUrl: String
)
