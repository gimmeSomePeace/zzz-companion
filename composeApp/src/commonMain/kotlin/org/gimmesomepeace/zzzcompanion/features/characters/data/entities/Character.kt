package org.gimmesomepeace.zzzcompanion.features.characters.data.entities


@JvmInline
value class CharacterId(val value: String)


data class Character (
    val id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId,
    val name: String,

    val factionId: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId,
    val attributeId: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId,
    val specialityId: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId,
    val rarityId: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId,

    val imageUrl: String,
)
