package org.zzzcompanion.disks.model


class Stat (
    val type: org.zzzcompanion.disks.model.StatType,
    val level: Int
) {
    companion object {
        fun placeholder(): org.zzzcompanion.disks.model.Stat {
            return _root_ide_package_.org.zzzcompanion.disks.model.Stat(
                type = _root_ide_package_.org.zzzcompanion.disks.model.StatType.EMPTY,
                level = 0
            )
        }
    }
}
