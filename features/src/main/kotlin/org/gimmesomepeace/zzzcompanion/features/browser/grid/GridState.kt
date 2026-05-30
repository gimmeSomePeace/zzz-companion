package org.gimmesomepeace.zzzcompanion.features.browser.grid

internal data class GridState<T>(
    val items: List<T>
) {
    companion object {
        fun <T> initial() = GridState<T>(
            items = emptyList()
        )
    }
}
