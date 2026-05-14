package org.gimmesomepeace.zzzcompanion.core.disk


/**
 * Агрегирует дополнительные характеристики в одну сущность.
 *
 * Инвариант: сумма уровней дополнительных характеристик не должна превышать 5.
 */
class SubStatsSet private constructor(
    val state1: SubStat,
    val state2: SubStat,
    val state3: SubStat,
    val state4: SubStat? = null,
) {
    companion object {
        fun create(state1: SubStat, state2: SubStat, state3: SubStat, state4: SubStat?): SubStatsSet {
            val statValueSum = state1.level.value + state2.level.value + state3.level.value + (state4?.level?.value ?: 0)
            require(statValueSum in 0..5) {
                "Sub stats values sum must be between 0 and 5 but was $statValueSum"
            }
            return SubStatsSet(state1, state2, state3, state4)
        }
    }
}
