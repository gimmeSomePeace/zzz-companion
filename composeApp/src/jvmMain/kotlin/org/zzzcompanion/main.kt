package org.zzzcompanion

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.compose.resources.painterResource
import zzz_companion.composeapp.generated.resources.Res
import zzz_companion.composeapp.generated.resources.icon


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ZZZ Companion",
        icon = painterResource(Res.drawable.icon),
        state = rememberWindowState(
            width = 800.dp,
            height = 600.dp,
            position = WindowPosition.Aligned(Alignment.Center),
        )
    ) {
        App()
    }
}
