package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.disks.Disk
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId


interface DiskRepository {
    fun getAllByCharacterId(characterId: CharacterId): List<Disk>
}
