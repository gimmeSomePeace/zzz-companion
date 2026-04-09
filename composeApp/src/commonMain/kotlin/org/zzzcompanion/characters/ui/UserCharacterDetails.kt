package org.zzzcompanion.characters.ui

import org.zzzcompanion.characters.model.Character


data class UserCharacterDetails(
    val id: Long,
    val character: CharacterDetails?,
    val disks: List<Long> = List(6) { -1 }
)
