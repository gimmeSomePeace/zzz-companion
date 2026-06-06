package me.gimmesomepeace.zzzcompanion.core.disk

private const val MAX_SUB_STAT_VALUE = 5

@JvmInline
value class SubStatValue(
    val value: Int,
) {
    init {
        require(value in 0..MAX_SUB_STAT_VALUE)
    }
}

/**
 * Сущность дополнительной характеристики.
 * Инвариант: уровень характеристики должен находиться строго в диапазоне от 0 до 5
 */
data class SubStat(
    val stat: Stat,
    val level: SubStatValue,
)
