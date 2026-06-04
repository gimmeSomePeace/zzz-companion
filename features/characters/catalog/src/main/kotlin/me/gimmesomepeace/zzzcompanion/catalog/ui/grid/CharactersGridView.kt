package me.gimmesomepeace.zzzcompanion.catalog.ui.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.gimmesomepeace.zzzcompanion.catalog.CharactersCatalogIntent
import me.gimmesomepeace.zzzcompanion.catalog.CharactersCatalogState

@Composable
fun CharactersGridView(
    state: CharactersCatalogState,
    onIntent: (CharactersCatalogIntent) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = state.items,
            key = { it.id },
        ) {
            Box(
                modifier =
                    Modifier.clickable {
                        if (it.isOwned) {
                            onIntent(CharactersCatalogIntent.GoToCharacterDetails(it.id))
                        } else {
                            onIntent(CharactersCatalogIntent.AddCharacterToOwned(it.id))
                        }
                    },
            ) {
                if (it.isOwned) {
                    ThumbCharacter(it)
                } else {
                    MissingThumbCharacter(it)
                }
            }
        }
    }
}
