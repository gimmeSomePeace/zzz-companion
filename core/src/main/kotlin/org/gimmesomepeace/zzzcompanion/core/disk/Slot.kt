package org.gimmesomepeace.zzzcompanion.core.disk


/**
 * Слот драйв-диска с набором основных характеристик, разрешенных для этого слота.
 */
enum class Slot(private val allowed: Set<StatType>) {
    S1(setOf(StatType.HP)),
    S2(setOf(StatType.ATTACK)),
    S3(setOf(StatType.DEFENSE)),

    S4(setOf(StatType.ANOMALY, StatType.DEFENSE_PERCENTAGE, StatType.HP_PERCENTAGE)),
    S5(setOf(StatType.ATTACK_PERCENTAGE)),
    S6(setOf(StatType.ANOMALY_CONTROL));

    /**
     * Проверяет, допустим ли указанный тип характеристики для данного слота.
     */
    fun isAllowed(type: StatType): Boolean = allowed.contains(type)
}