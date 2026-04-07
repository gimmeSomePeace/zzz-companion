package org.zzzcompanion.characters.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.zzzcompanion.characters.model.UserCharacter


@Composable
fun CharactersList(characters: List<UserCharacter>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(characters) {item ->

            ThumbCharacter(item.character)
        }
    }
}
