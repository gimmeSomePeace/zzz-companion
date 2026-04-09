package org.zzzcompanion.features.characters.data.entities


data class Character (
    val id: Long,
    val name: String,

    val factionId: Long,
    val attributeId: Long,
    val specialityId: Long,
    val rarityId: Long,

    val imageUrl: String,
)
