package org.gimmesomepeace.zzzcompanion.core.repository

data class Page<T>(
    val items: List<T>,
    val nextCursor: String?,
)