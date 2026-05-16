package org.gimmesomepeace.zzzcompanion.core.disk

/**
 * Слот драйв-диска с набором основных характеристик, разрешенных для этого слота.
 */
enum class Slot(private val allowed: Set<Stat>) {
    S1(setOf(Stat.HP)),
    S2(setOf(Stat.ATTACK)),
    S3(setOf(Stat.DEFENSE)),

    S4(setOf(Stat.ANOMALY, Stat.DEFENSE_PERCENTAGE, Stat.HP_PERCENTAGE)),
    S5(setOf(Stat.ATTACK_PERCENTAGE)),
    S6(setOf(Stat.ANOMALY_CONTROL)),
    ;

    /**
     * Проверяет, допустим ли указанный тип характеристики для данного слота.
     */
    fun isAllowed(type: Stat): Boolean = allowed.contains(type)
}
