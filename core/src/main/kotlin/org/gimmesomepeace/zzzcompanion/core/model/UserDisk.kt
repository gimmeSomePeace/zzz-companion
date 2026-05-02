package org.gimmesomepeace.zzzcompanion.core.model

import org.zzzcompanion.disks.model.Stat

class UserDisk (
    val id: Long,
    val diskTypeId: Long,

    mainStat: Stat,
    additionalStates: List<Stat>
) {
    companion object {
    }
}