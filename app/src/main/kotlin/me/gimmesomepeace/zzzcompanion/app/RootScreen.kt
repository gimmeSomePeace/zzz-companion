package me.gimmesomepeace.zzzcompanion.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import me.gimmesomepeace.zzzcompanion.browser.CharactersScreen

/**
 * Корневой экран приложения.
 *
 * Выступает точкой входа в UI и делегирует отображение активному дочернему компоненту.
 *
 * @param component компонент, управляющий навигацией приложения.
 */
@Composable
fun RootScreen(component: RootComponent) {
    val stack by component.stack.subscribeAsState()

    when (val child = stack.active.instance) {
        is RootComponent.Child.CharactersListChild -> CharactersScreen(child.component)
    }
}
