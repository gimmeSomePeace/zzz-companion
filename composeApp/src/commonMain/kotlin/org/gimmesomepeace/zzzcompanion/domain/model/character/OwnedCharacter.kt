package org.gimmesomepeace.zzzcompanion.domain.model.character


@JvmInline
value class OwnedCharacterId(val value: String)


class OwnedCharacter (
    val id: OwnedCharacterId,
    val characterId: CharacterId,
    val disks: List<String> = List(6) { "-1" }
)
