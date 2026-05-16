package org.gimmesomepeace.uikit.select

import java.net.URI

sealed interface SelectOption<out T> {
    val title: String
    val imageUrl: URI?

    data class Item<T>(
        val value: T,
        override val title: String,
        override val imageUrl: URI? = null,
    ) : SelectOption<T>

    data object All : SelectOption<Nothing> {
        override val title: String = "-- Все --"
        override val imageUrl: URI? = null
    }
}
