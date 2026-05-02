package org.gimmesomepeace.zzzcompanion.core.model.disks

import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskId
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskTypeId


class Disk private constructor(
    val id: DiskId,
    val diskTypeId: DiskTypeId,

    val characterId: CharacterId,
    val position: Position,

    val mainStat: MainStatSlot,
    val subStats: SubStats
) {
    companion object {
        fun create(
            id: DiskId,
            diskTypeId: DiskTypeId,
            characterId: CharacterId,
            position: Position,
            mainStat: MainStatSlot,
            subStats: SubStats
        ): Disk {
            require(position.isAllowed(mainStat.type)) {
                "Stat (${mainStat.type}) should be allowed when position is $position"
            }
            return Disk(id, diskTypeId, characterId, position, mainStat, subStats)
        }
    }
}
