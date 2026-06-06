package me.gimmesomepeace.zzzcompanion.browser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.gimmesomepeace.zzzcompanion.catalog.ui.grid.CharactersGridView
import me.gimmesomepeace.zzzcompanion.filters.ui.FiltersBar

@Composable
fun CharactersScreen(component: CharactersBrowserComponent) {
    val state = component.state.collectAsState().value

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        FiltersBar(component.filterComponent)

        Spacer(modifier = Modifier.height(8.dp))

        CharactersGridView(
            state = state.grid,
            onIntent = component::onCharactersCatalogIntent,
        )
    }
}
