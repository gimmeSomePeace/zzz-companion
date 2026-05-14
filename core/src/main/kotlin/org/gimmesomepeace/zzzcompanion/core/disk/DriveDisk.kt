package org.gimmesomepeace.zzzcompanion.core.disk

import org.gimmesomepeace.zzzcompanion.core.disktype.DiskTypeId


/**
 * Сущность драйв-диска.
 *
 * Диски используются как основной способ усиления персонажей.
 * Диск имеет:
 *  - Вид диска (дает фиксированные усиления игровых механик)
 *  - Основную характеристику (усиливается сильнее остальных, назначается рандомно сразу при создании диска)
 *  - Набор дополнительных характеристик (изменить их нельзя, назначаются рандомно сразу при создании диска)
 *  - Позицию
 *
 *  Возможные основные характеристики зависят от позиции диска.
 *  Условно если позиция диска 1, то ему доступна только 1 основная характеристика - усиление HP.
 *  На дополнительные характеристики таких ограничений не накладывается.
 *
 *
 *  @property mainStat Основная характеристика
 *  @property subStats Набор дополнительных характеристик
 */

class DriveDisk private constructor(
    val id: DriveDiskId,
    val diskTypeId: DiskTypeId,

    val position: Position,

    val mainStat: MainStatSlot,
    val subStats: SubStats
) {
    companion object {
        fun create(
            id: DriveDiskId,
            diskTypeId: DiskTypeId,
            position: Position,
            mainStat: MainStatSlot,
            subStats: SubStats
        ): DriveDisk {
            require(position.isAllowed(mainStat.type)) {
                "Stat (${mainStat.type}) should be allowed when position is $position"
            }
            return DriveDisk(id, diskTypeId, position, mainStat, subStats)
        }
    }
}
