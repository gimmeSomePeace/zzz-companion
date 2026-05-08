package org.gimmesomepeace.zzzcompanion.core.disk


/**
 * Сущность позиции персонажа.
 *
 * Используется для фиксации наборов разрешенных типов основных характеристик на конкретной позиции.
 */
enum class Position(private val allowed: Set<StatType>) {
    P1(setOf(StatType.HP)),
    P2(setOf(StatType.ATTACK)),
    P3(setOf(StatType.DEFENSE)),

    P4(setOf(StatType.ANOMALY, StatType.DEFENSE_PERCENTAGE, StatType.HP_PERCENTAGE)),
    P5(setOf(StatType.ATTACK_PERCENTAGE)),
    P6(setOf(StatType.ANOMALY_CONTROL));

    fun isAllowed(type: StatType): Boolean = allowed.contains(type)
}