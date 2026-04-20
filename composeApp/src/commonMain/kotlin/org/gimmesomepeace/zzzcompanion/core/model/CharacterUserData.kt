package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterUserDataId
import org.zzzcompanion.disks.model.Disk


data class CharacterUserData(
    val id: CharacterUserDataId,
    val characterId: CharacterId,
    val disks: List<Disk>,
)
