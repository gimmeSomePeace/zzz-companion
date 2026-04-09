package org.zzzcompanion.characters.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.zzzcompanion.characters.model.Character


@Composable
fun CharactersList(owned: List<UserCharacterDetails>, missing: List<CharacterDetails>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(owned) {item ->
            if (item.character != null) ThumbCharacter(item.character)
        }
        // TODO: missing characters ui
    }
}
