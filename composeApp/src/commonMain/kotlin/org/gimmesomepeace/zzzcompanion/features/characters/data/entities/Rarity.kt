package org.gimmesomepeace.zzzcompanion.features.characters.data.entities


@JvmInline
value class RarityId(val value: String)

data class Rarity(
    val id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId,
    val name: String,
    val imageUrl: String
)
