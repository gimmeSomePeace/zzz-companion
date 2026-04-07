package org.zzzcompanion.characters.model


data class Character (
    val id: Int,
    val name: String,

    val faction: Faction,
    val attribute: Attribute,
    val speciality: Speciality,
    val rarity: Rarity,

    val imageUrl: String,
)
