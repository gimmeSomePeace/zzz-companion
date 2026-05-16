package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.disk.DriveDiskId
import org.gimmesomepeace.zzzcompanion.core.disk.Slot

/**
 * Экипировка дисков персонажа по слотам.
 *
 * Хранит соответствие между слотами и установленными дисками.
 * Отсутствие записи означает, что слот пуст.
 */
@ConsistentCopyVisibility
data class EquippedDisks private constructor(
    private val disks: Map<Slot, DriveDiskId>,
) {
    companion object {
        fun create(disks: Map<Slot, DriveDiskId> = emptyMap()) = EquippedDisks(disks)
    }

    fun isFree(slot: Slot): Boolean = disks.containsKey(slot)
    fun getDisk(slot: Slot): DriveDiskId? = disks[slot]

    fun equip(slot: Slot, diskId: DriveDiskId): EquippedDisks = EquippedDisks(
        disks + (slot to diskId)
    )

    fun setFree(slot: Slot): EquippedDisks = EquippedDisks(
        disks - slot
    )
}
