package org.zzzcompanion.disks.model


class Stat (
    val type: StatType,
    val level: Int
) {
    companion object {
        fun placeholder(): Stat {
            return Stat(
                type = StatType.EMPTY,
                level = 0
            )
        }
    }
}
