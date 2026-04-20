package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId


@JvmInline
value class OwnedCharacterId(val value: String)


class OwnedCharacter (
    val id: OwnedCharacterId,
    val characterId: CharacterId,
    val disks: List<String> = List(6) { "-1" }
)
