package org.gimmesomepeace.zzzcompanion.features.browser.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.browser.filter.CharactersFilterBar
import org.gimmesomepeace.zzzcompanion.features.browser.grid.GridUi


@Composable
fun CharactersScreen(component: CharactersListComponent) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CharactersFilterBar(component.filterComponent)

        Spacer(modifier = Modifier.height(8.dp))

        GridUi(
            component = component.gridComponent,
            idSelector = { it.id.value },
            itemCard = @Composable {
                if (it.isOwned) ThumbCharacter(it)
                else MissingThumbCharacter(it)
            }
        )
    }
}
