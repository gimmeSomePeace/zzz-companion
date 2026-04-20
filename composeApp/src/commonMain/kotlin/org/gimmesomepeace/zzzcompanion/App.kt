package org.gimmesomepeace.zzzcompanion

import androidx.compose.runtime.Composable
import org.gimmesomepeace.zzzcompanion.features.browser.ui.CharactersScreen
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent


@Composable
fun App(component : CharactersListComponent) {
    CharactersScreen(component)
}
