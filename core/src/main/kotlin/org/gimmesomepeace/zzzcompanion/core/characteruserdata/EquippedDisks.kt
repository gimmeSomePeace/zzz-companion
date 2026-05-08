package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.disk.DiskId
import org.gimmesomepeace.zzzcompanion.core.disk.Position

data class EquippedDisks(
    private val disks: Map<Position, DiskId> = emptyMap()
) {
    fun isEquipped(position: Position): Boolean = disks.containsKey(position)
    fun getDisk(position: Position): DiskId? = disks[position]
    fun equip(position: Position, diskId: DiskId): EquippedDisks = EquippedDisks(
        disks + (position to diskId)
    )
    fun unequip(position: Position): EquippedDisks = EquippedDisks(
        disks - position
    )
}
