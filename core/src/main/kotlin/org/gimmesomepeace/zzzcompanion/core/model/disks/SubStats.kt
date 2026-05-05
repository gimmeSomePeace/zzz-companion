package org.gimmesomepeace.zzzcompanion.core.model.disks


/**
 * Агрегирует дополнительные характеристики в одну сущность.
 *
 * Инвариант: сумма уровней дополнительных характеристик не должна превышать 5.
 */
class SubStats private constructor(
    val state1: SubStatSlot,
    val state2: SubStatSlot,
    val state3: SubStatSlot,
    val state4: SubStatSlot? = null,
) {
    companion object {
        fun create(state1: SubStatSlot, state2: SubStatSlot, state3: SubStatSlot, state4: SubStatSlot?): SubStats {
            val statValueSum = state1.level.value + state2.level.value + state3.level.value + (state4?.level?.value ?: 0)
            require(statValueSum in 0..5) {
                "Sub stats values sum must be between 0 and 5 but was $statValueSum"
            }
            return SubStats(state1, state2, state3, state4)
        }
    }
}
