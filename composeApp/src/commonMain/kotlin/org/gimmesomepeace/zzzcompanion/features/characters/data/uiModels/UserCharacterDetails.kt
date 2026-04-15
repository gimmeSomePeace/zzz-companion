package org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels

import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.UserCharacterId


data class UserCharacterDetails(
    val id: UserCharacterId,
    val character: CharacterDetails?,
    val disks: List<Long> = List(6) { -1 }
)
