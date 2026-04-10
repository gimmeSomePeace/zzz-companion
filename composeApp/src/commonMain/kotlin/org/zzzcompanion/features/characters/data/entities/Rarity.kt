package org.zzzcompanion.features.characters.data.entities


@JvmInline
value class RarityId(val value: String)

data class Rarity(
    val id: RarityId,
    val name: String,
    val imageUrl: String
)
