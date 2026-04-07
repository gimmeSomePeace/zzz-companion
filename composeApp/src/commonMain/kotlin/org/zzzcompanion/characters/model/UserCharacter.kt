package org.zzzcompanion.characters.model

import org.zzzcompanion.disks.model.UserDisk


class UserCharacter (
    val character: Character,
    disks: List<UserDisk> = List(6) { UserDisk.placeholder() }
) {
    var disks: List<UserDisk> = disks
        private set
}
