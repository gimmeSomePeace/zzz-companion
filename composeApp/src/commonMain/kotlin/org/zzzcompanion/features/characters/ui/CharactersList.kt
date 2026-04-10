package org.zzzcompanion.features.characters.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.zzzcompanion.features.characters.data.entities.CharacterId


@Composable
fun CharactersList(characters: List<CharacterUi>, onAddCharacter: (CharacterId) -> Unit) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            characters,
            key = {
                when (it) {
                    is CharacterUi.Owned -> it.data.character?.id ?: it.hashCode()
                    is CharacterUi.Missing -> it.data.id
                }
            }
        ) { item ->
            when (item) {
                is CharacterUi.Owned -> {
                    item.data.character?.let { ThumbCharacter(it) }
                }
                is CharacterUi.Missing -> {
                    MissingThumbCharacter(item.data, onAddCharacter)
                }
            }
        }
    }
}
