package org.gimmesomepeace.zzzcompanion

import androidx.compose.runtime.Composable
import org.gimmesomepeace.zzzcompanion.presentation.ui.character.CharactersScreen
import org.gimmesomepeace.zzzcompanion.presentation.component.CharactersListComponent


@Composable
fun App(component : CharactersListComponent) {
    CharactersScreen(component)
}
