package org.gimmesomepeace.uikit

import java.net.URI

fun <T> SelectOption<T>.toValueOrNull(): T? {
    return when (this) {
        is SelectOption.Item -> value
        SelectOption.All -> null
    }
}

fun <T> SelectOption<T>.matches(selected: T?): Boolean {
    return when (this) {
        is SelectOption.Item -> this.value == selected
        SelectOption.All -> selected == null
    }
}

sealed interface SelectOption<out T> {
    val title: String
    val imageUrl: URI?

    data class Item<T>(
        val value: T,
        override val title: String,
        override val imageUrl: URI? = null
    ): SelectOption<T>

    data object All: SelectOption<Nothing> {
        override val title: String = "-- Все --"
        override val imageUrl: URI? = null
    }
}
