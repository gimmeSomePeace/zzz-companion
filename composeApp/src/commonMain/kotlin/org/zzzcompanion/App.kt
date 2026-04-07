package org.zzzcompanion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.zzzcompanion.characters.ui.CharactersScreen
import org.zzzcompanion.characters.viewmodel.CharacterViewModel

@Composable
fun App() {
    val viewModel = remember { CharacterViewModel() }

    CharactersScreen(viewModel)
}
