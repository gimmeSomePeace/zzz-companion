package org.gimmesomepeace.zzzcompanion.core.disk

@JvmInline
value class SubStatValue(val value: Int) {
    init { require(value in 0..5) }
}

/**
 * Сущность дополнительной характеристики.
 * Инвариант: уровень характеристики должен находиться строго в диапазоне от 0 до 5
 */
data class SubStat(
    val stat: Stat,
    val level: SubStatValue,
)
