package org.gimmesomepeace.zzzcompanion.domain.model.character


@JvmInline
value class CharacterId(val value: String)


data class Character (
    val id: CharacterId,
    val name: String,

    val factionId: FactionId,
    val attributeId: AttributeId,
    val specialityId: SpecialityId,
    val rarityId: RarityId,

    val imageUrl: String,
)
