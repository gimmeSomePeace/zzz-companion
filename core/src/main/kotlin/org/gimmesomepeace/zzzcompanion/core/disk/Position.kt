package org.gimmesomepeace.zzzcompanion.core.disk


/**
 * Позиция драйв-диска с набором основных характеристик, разрешенных для этой позиции.
 */
enum class Position(private val allowed: Set<StatType>) {
    P1(setOf(StatType.HP)),
    P2(setOf(StatType.ATTACK)),
    P3(setOf(StatType.DEFENSE)),

    P4(setOf(StatType.ANOMALY, StatType.DEFENSE_PERCENTAGE, StatType.HP_PERCENTAGE)),
    P5(setOf(StatType.ATTACK_PERCENTAGE)),
    P6(setOf(StatType.ANOMALY_CONTROL));

    /**
     * Проверяет, допустим ли указанный тип характеристики для данной позиции.
     */
    fun isAllowed(type: StatType): Boolean = allowed.contains(type)
}