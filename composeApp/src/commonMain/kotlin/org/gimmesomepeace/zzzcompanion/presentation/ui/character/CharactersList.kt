package org.gimmesomepeace.zzzcompanion.presentation.ui.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.presentation.model.character.CharacterUi


@Composable
fun CharactersList(characters: List<CharacterUi>, onMissingCharacterClick: (CharacterId) -> Unit) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            characters,
            key = { it.id.value }
        ) { item ->
            if (item.isOwned) { ThumbCharacter(item) }
            else MissingThumbCharacter(item, onMissingCharacterClick)
        }
    }
}
