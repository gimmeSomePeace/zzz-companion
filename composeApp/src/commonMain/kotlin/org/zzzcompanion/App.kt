package org.zzzcompanion

import androidx.compose.runtime.Composable
import org.zzzcompanion.features.characters.ui.CharactersScreen
import org.zzzcompanion.features.characters.domain.CharactersListComponent


@Composable
fun App(component : CharactersListComponent) {
    CharactersScreen(component)
}
