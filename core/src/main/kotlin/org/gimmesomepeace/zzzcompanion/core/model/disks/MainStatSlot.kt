package org.gimmesomepeace.zzzcompanion.core.model.disks


@JvmInline
value class MainStatValue(val value: Int) {
    init { require(value in 0..15) }
}

data class MainStatSlot(
    val type: StatType,
    val value: MainStatValue,
)
