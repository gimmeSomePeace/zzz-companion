package org.gimmesomepeace.zzzcompanion.core.shared


@JvmInline
value class PageSize(val value: Int) {
    init {
        require(value > 0) { "Page size must be greater than 0" }
    }
}
