package org.zzzcompanion.characters.model


class UserCharacter (
    val id: Long,
    val characterId: Long,
    val disks: List<Long> = List(6) { -1 }
) {
}
