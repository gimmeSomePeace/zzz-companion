package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.disk.DiskId
import org.gimmesomepeace.zzzcompanion.core.disk.Position

/**
 * Экипировка дисков персонажа по позициям.
 *
 * Хранит соответствие между слотами (Position) и установленными дисками.
 * Отсутствие записи для позиции означает, что слот пуст.
 */
@ConsistentCopyVisibility
data class EquippedDisks private constructor(
    private val disks: Map<Position, DiskId>
) {
    companion object {
        fun create(
            disks: Map<Position, DiskId> = emptyMap()
        ) = EquippedDisks(disks)
    }

    fun isEquipped(position: Position): Boolean = disks.containsKey(position)
    fun getDisk(position: Position): DiskId? = disks[position]

    fun equip(position: Position, diskId: DiskId): EquippedDisks = EquippedDisks(
        disks + (position to diskId)
    )

    fun unequip(position: Position): EquippedDisks = EquippedDisks(
        disks - position
    )
}
