package org.gimmesomepeace.zzzcompanion.core.disk

/**
 * Агрегирует дополнительные характеристики в одну сущность.
 *
 * Инвариант: сумма уровней дополнительных характеристик не должна превышать 5.
 *
 * @property stat1 Первая характеристика
 * @property stat2 Вторая характеристика
 * @property stat3 Третья характеристика
 * @property stat4 Четвертая характеристика
 */
class SubStatsSet private constructor(
    val stat1: SubStat,
    val stat2: SubStat,
    val stat3: SubStat,
    val stat4: SubStat? = null,
) {
    companion object {
        fun create(stat1: SubStat, stat2: SubStat, stat3: SubStat, stat4: SubStat?): SubStatsSet {
            val statValueSum =
                stat1.level.value +
                    stat2.level.value +
                    stat3.level.value +
                    (stat4?.level?.value ?: 0)

            require(statValueSum in 0..5) {
                "Sub stats values sum must be between 0 and 5 but was $statValueSum"
            }
            return SubStatsSet(stat1, stat2, stat3, stat4)
        }
    }
}
