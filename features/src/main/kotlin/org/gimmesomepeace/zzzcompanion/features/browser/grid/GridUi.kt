package org.gimmesomepeace.zzzcompanion.features.browser.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun <T> GridUi(
    component: GridComponent<T>,
    idSelector: (T) -> Any,
    itemCard: @Composable (T) -> Unit,
) {
    val state by component.state.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            state.items,
            key = { idSelector(it) }
        ) {
            Box(modifier = Modifier.clickable {
                component.onIntent(GridIntent.ItemClickedIntent(it))
            } ) {
                itemCard(it)
            }
        }
    }
}
