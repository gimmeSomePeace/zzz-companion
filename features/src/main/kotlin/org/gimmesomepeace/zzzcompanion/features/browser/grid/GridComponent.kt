package org.gimmesomepeace.zzzcompanion.features.browser.grid

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class GridComponent<T>(
    val onItemClicked: (T) -> Unit,
    items: StateFlow<List<T>>,
    scope: CoroutineScope,
) {
    val state: StateFlow<GridState<T>> =
        items
            .map { GridState(it) }
            .stateIn(
                scope = scope,
                started = SharingStarted.Eagerly,
                initialValue = GridState.initial()
            )

    fun onIntent(intent: GridIntent<T>) {
        when (intent) {
            is GridIntent.ItemClicked -> onItemClicked(intent.item)
        }
    }
}