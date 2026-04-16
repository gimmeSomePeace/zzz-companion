package org.gimmesomepeace.zzzcompanion.domain.model.character


@JvmInline
value class RarityId(val value: String)

data class Rarity(
    val id: RarityId,
    val name: String,
    val imageUrl: String
)
