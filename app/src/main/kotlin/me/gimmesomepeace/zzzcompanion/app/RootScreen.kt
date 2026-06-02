package me.gimmesomepeace.zzzcompanion.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import me.gimmesomepeace.zzzcompanion.browser.CharactersScreen

@Composable
fun RootScreen(component: RootComponent) {
    val stack by component.stack.subscribeAsState()

    when (val child = stack.active.instance) {
        is RootComponent.Child.CharactersListChild -> CharactersScreen(child.component)
    }
}
