package org.zzzcompanion

import androidx.compose.runtime.Composable
import org.zzzcompanion.characters.ui.CharactersScreen
import org.zzzcompanion.characters.viewmodel.CharactersListComponent


@Composable
fun App(component : CharactersListComponent) {
    CharactersScreen(component)
}
