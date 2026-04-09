package org.zzzcompanion.characters.model


data class Character (
    val id: Long,
    val name: String,

    val factionId: Long,
    val attributeId: Long,
    val specialityId: Long,
    val rarityId: Long,

    val imageUrl: String,
)
