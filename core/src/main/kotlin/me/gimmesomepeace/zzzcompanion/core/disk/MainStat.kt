package me.gimmesomepeace.zzzcompanion.core.disk

private const val MIN_MAIN_STAT_VALUE = 0
private const val MAX_MAIN_STAT_VALUE = 15

@JvmInline
value class MainStatValue(
    val value: Int,
) {
    init {
        require(value in MIN_MAIN_STAT_VALUE..MAX_MAIN_STAT_VALUE)
    }
}

/**
 * Сущность основной характеристики.
 * Инвариант: уровень характеристики должен находиться строго в диапазоне от 0 до 15
 */
data class MainStat(
    val stat: Stat,
    val value: MainStatValue,
)
