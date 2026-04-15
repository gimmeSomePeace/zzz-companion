package org.gimmesomepeace.zzzcompanion.features.characters.data.entities


@JvmInline
value class UserCharacterId(val value: String)


class UserCharacter (
    val id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId,
    val characterId: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId,
    val disks: List<Long> = List(6) { -1 }
)
