package org.gimmesomepeace.zzzcompanion

import androidx.compose.runtime.Composable
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.ui.CharactersScreen
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.CharactersListComponent


@Composable
fun App(component : CharactersListComponent) {
    CharactersScreen(component)
}
