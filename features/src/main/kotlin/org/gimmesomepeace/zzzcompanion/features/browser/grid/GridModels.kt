package org.gimmesomepeace.zzzcompanion.features.browser.grid

sealed interface GridIntent<T> {
    data class ItemClickedIntent<T>(val item: T) : GridIntent<T>
}

sealed interface GridEvent<T> {
    data class ItemClickedEvent<T>(val item: T) : GridEvent<T>
}
