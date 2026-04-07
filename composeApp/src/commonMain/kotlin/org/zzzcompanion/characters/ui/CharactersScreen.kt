package org.zzzcompanion.characters.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.zzzcompanion.characters.viewmodel.CharacterViewModel


@Composable
fun CharactersScreen(viewModel: CharacterViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = viewModel.searchQuery,
            onValueChange = viewModel::onSearchQueryChanged,
            placeholder = { Text("Search...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        CharactersList(viewModel.filteredCharacters)
    }
}
