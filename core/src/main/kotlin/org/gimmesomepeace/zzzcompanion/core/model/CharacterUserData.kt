package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId


data class CharacterUserData(
    val id: CharacterId,
    val disks: List<Disk>,
)
