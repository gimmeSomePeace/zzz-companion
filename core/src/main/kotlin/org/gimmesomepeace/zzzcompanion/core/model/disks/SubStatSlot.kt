package org.gimmesomepeace.zzzcompanion.core.model.disks

@JvmInline
value class SubStatValue(val value: Int) {
    init { require(value in 0..5) }
}

data class SubStatSlot(
    val type: StatType,
    val level: SubStatValue,
)
