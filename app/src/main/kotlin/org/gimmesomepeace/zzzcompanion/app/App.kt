package org.gimmesomepeace.zzzcompanion.app

import androidx.compose.runtime.Composable
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.app.features.browser.ui.CharactersScreen


@Composable
fun App(component : CharactersListComponent) {
    CharactersScreen(component)
}
