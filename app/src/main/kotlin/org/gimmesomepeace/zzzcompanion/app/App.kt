package org.gimmesomepeace.zzzcompanion.app

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import org.gimmesomepeace.zzzcompanion.app.features.browser.ui.CharactersScreen
import org.gimmesomepeace.zzzcompanion.app.features.details.DetailsScreen


@Composable
fun App(component : RootComponent) {

    Children(
        stack = component.childStack,
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Details -> DetailsScreen(
                component = child.component
            )
            is RootComponent.Child.List -> CharactersScreen(
                component = child.component
            )
        }
    }
}
