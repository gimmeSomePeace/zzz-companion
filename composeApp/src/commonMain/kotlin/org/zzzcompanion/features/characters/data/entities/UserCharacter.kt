package org.zzzcompanion.features.characters.data.entities


@JvmInline
value class UserCharacterId(val value: String)


class UserCharacter (
    val id: UserCharacterId,
    val characterId: CharacterId,
    val disks: List<Long> = List(6) { -1 }
)
