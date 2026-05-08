package org.gimmesomepeace.zzzcompanion.core.repository


@JvmInline
value class PageSize(val value: Int) {
    init {
        require(value in 0..100) { "Page size must be between 0 and 100" }
    }
}
