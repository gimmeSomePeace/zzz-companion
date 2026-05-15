package org.gimmesomepeace.zzzcompanion.core.disk

import org.gimmesomepeace.zzzcompanion.core.diskset.DriveDiskSetId

/**
 * Сущность драйв-диска.
 *
 * Диски используются как основной способ усиления персонажей.
 * Диск имеет:
 *  - Вид диска (дает фиксированные усиления игровых механик)
 *  - Основную характеристику (усиливается сильнее остальных, назначается рандомно сразу при создании диска)
 *  - Набор дополнительных характеристик (изменить их нельзя, назначаются рандомно сразу при создании диска)
 *  - Допустимый слот
 *
 *  Возможные основные характеристики зависят от допустимого слота диска.
 *  Условно если допустимый слот диска - 1, то ему доступна только 1 основная характеристика - усиление HP.
 *  На дополнительные характеристики таких ограничений не накладывается.
 *
 *  @property id Уникальный идентификатор
 *  @property diskTypeId Идентификатор сета
 *  @property allowedSlot Слот, к которому диск подходит
 *  @property mainStat Основная характеристика
 *  @property subStats Набор дополнительных характеристик
 */

class DriveDisk private constructor(
    val id: DriveDiskId,
    val diskTypeId: DriveDiskSetId,

    val allowedSlot: Slot,

    val mainStat: MainStat,
    val subStats: SubStatsSet,
) {
    companion object {
        fun create(
            id: DriveDiskId,
            diskTypeId: DriveDiskSetId,
            allowedSlot: Slot,
            mainStat: MainStat,
            subStats: SubStatsSet,
        ): DriveDisk {
            require(allowedSlot.isAllowed(mainStat.stat)) {
                "Stat (${mainStat.stat}) should be allowed when allowed slot is $allowedSlot"
            }
            return DriveDisk(id, diskTypeId, allowedSlot, mainStat, subStats)
        }
    }
}
