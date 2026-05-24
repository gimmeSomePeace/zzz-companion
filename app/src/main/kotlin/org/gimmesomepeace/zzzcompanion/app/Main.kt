package org.gimmesomepeace.zzzcompanion.app

import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.gimmesomepeace.zzzcompanion.features.browser.factory.InMemoryCharactersListComponentFactory

fun main() = application {
    val lifecycle = LifecycleRegistry()
    val context = DefaultComponentContext(lifecycle = lifecycle)

    val charactersListComponentFactory = InMemoryCharactersListComponentFactory()

    val rootComponent = RootComponent(
        componentContext = context,
        charactersListComponentFactory = charactersListComponentFactory,
    )

    Window(
        onCloseRequest = ::exitApplication,
        title = "ZZZ Companion",
        icon = painterResource("icon.ico"),
        state = rememberWindowState(
            width = 1200.dp,
            height = 600.dp,
            position = WindowPosition.Aligned(Alignment.Center)
        )
    ) {
        RootScreen(rootComponent)
    }
}
