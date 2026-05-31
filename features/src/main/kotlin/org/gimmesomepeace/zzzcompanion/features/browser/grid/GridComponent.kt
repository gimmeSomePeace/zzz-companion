package org.gimmesomepeace.zzzcompanion.features.browser.grid

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class GridComponent<T>(
    items: StateFlow<List<T>>,
    val scope: CoroutineScope,
) {
    val state: StateFlow<GridState<T>> =
        items
            .map { GridState(it) }
            .stateIn(
                scope = scope,
                started = SharingStarted.Eagerly,
                initialValue = GridState.initial()
            )

    private val _events = MutableSharedFlow<GridEvent<T>>()
    val events = _events.asSharedFlow()

    fun onIntent(intent: GridIntent<T>) {
        when (intent) {
            is GridIntent.ItemClickedIntent -> scope.launch {
                _events.emit(GridEvent.ItemClickedEvent(intent.item))
            }
        }
    }
}