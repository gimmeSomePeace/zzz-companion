package org.gimmesomepeace.zzzcompanion.core.disk


@JvmInline
value class MainStatValue(val value: Int) {
    init { require(value in 0..15) }
}

/**
 * Сущность основной характеристики.
 * Инвариант: уровень характеристики должен находиться строго в диапазоне от 0 до 15
 */
data class MainStat(
    val type: StatType,
    val value: MainStatValue,
)
