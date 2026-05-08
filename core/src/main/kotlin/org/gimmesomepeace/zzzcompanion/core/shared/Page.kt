package org.gimmesomepeace.zzzcompanion.core.shared

data class Page<T>(
    val items: List<T>,
    val nextCursor: String?,
)