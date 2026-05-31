package org.gimmesomepeace.zzzcompanion.core.shared

interface Filter<T> {
    fun toPredicate(): (T) -> Boolean
}
