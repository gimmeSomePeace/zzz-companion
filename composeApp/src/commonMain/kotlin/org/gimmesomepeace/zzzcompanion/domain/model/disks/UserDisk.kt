package org.zzzcompanion.disks.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class UserDisk (
    val id: Long,
    val diskTypeId: Long,

    mainStat: Stat,
    additionalStates: List<Stat>
) {
    companion object {
        fun placeholder(): UserDisk {
            return UserDisk(
                id = -1,
                diskTypeId = -1,
                mainStat = Stat.placeholder(),
                additionalStates = List(4) { Stat.placeholder() }
            )
        }
    }

    var mainStat by mutableStateOf(mainStat)
        private set

    var additionalStates by mutableStateOf(additionalStates)
        private set
}