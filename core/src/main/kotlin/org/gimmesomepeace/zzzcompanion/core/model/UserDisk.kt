package org.zzzcompanion.disks.model

class UserDisk (
    val id: Long,
    val diskTypeId: Long,

    mainStat: org.zzzcompanion.disks.model.Stat,
    additionalStates: List<org.zzzcompanion.disks.model.Stat>
) {
    companion object {
    }
}