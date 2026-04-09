package org.zzzcompanion.features.characters.data.entities


class UserCharacter (
    val id: Long,
    val characterId: Long,
    val disks: List<Long> = List(6) { -1 }
) {
}
