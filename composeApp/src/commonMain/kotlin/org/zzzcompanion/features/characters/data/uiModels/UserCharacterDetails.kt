package org.zzzcompanion.features.characters.data.uiModels


data class UserCharacterDetails(
    val id: Long,
    val character: CharacterDetails?,
    val disks: List<Long> = List(6) { -1 }
)
