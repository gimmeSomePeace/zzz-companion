package org.gimmesomepeace.zzzcompanion.core.model.disks

import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskId
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskTypeId


/**
 * Сущность драйв-диска.
 *
 * Диски используются как основной способ усиления персонажей.
 * Диск имеет:
 *  - Вид диска (дает фиксированные усиления игровых механик)
 *  - Основную характеристику (усиливается сильнее остальных, назначается рандомно сразу при создании диска)
 *  - 3-4 дополнительных характеристики (изменить их нельзя, назначаются рандомно сразу при создании диска)
 *  - Позицию (от 1 до 6)
 *
 *  Возможные основные характеристики зависят от позиции диска.
 *  Условно если позиция диска 1, то ему доступна только 1 основная характеристика - усиление HP.
 *  На дополнительные характеристики таких ограничений не накладывается.
 *  Основная характеристика имеет уровень усиления от 0 до 15.
 *  На доп характеристики доступно 5 очков усиления.
 *  Распределяются рандомно самой игрой между выпавшими доп характеристиками.
 *
 *  @property id Уникальный идентификатор диска
 *  @property diskTypeId Вид диска
 *  @property characterId Идентификатор персонажа, к которому применен диск
 *  @property position Позиция диска (от 1 до 6)
 *  @property mainStat Основная характеристика
 *  @property subStats Набор дополнительных характеристик
 */

class Disk private constructor(
    val id: DiskId,
    val diskTypeId: DiskTypeId,

    val characterId: CharacterId,
    val position: Position,

    val mainStat: MainStatSlot,
    val subStats: SubStats
) {
    companion object {
        fun create(
            id: DiskId,
            diskTypeId: DiskTypeId,
            characterId: CharacterId,
            position: Position,
            mainStat: MainStatSlot,
            subStats: SubStats
        ): Disk {
            require(position.isAllowed(mainStat.type)) {
                "Stat (${mainStat.type}) should be allowed when position is $position"
            }
            return Disk(id, diskTypeId, characterId, position, mainStat, subStats)
        }
    }
}
