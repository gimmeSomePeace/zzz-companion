package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.zzzcompanion.disks.model.Disk


data class CharacterUserData(
    val id: org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId,
    val disks: List<org.zzzcompanion.disks.model.Disk>,
)
