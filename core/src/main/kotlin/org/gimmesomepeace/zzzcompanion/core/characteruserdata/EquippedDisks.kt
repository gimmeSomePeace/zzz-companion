package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.disk.DriveDiskId
import org.gimmesomepeace.zzzcompanion.core.disk.Position

/**
 * Экипировка дисков персонажа по позициям.
 *
 * Хранит соответствие между слотами (Position) и установленными дисками.
 * Отсутствие записи для позиции означает, что слот пуст.
 */
@ConsistentCopyVisibility
data class EquippedDisks private constructor(
    private val disks: Map<Position, DriveDiskId>
) {
    companion object {
        fun create(
            disks: Map<Position, DriveDiskId> = emptyMap()
        ) = EquippedDisks(disks)
    }

    fun isEquipped(position: Position): Boolean = disks.containsKey(position)
    fun getDisk(position: Position): DriveDiskId? = disks[position]

    fun equip(position: Position, diskId: DriveDiskId): EquippedDisks = EquippedDisks(
        disks + (position to diskId)
    )

    fun unequip(position: Position): EquippedDisks = EquippedDisks(
        disks - position
    )
}
