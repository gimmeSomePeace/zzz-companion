package org.gimmesomepeace.zzzcompanion.features.browser.grid

sealed interface GridIntent<T> {
    data class ItemClicked<T>(val item: T) : GridIntent<T>
}
