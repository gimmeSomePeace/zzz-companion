package org.gimmesomepeace.zzzcompanion.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.browser.factory.CharactersListComponentFactory


class RootComponent(
    componentContext: ComponentContext,
    val charactersListComponentFactory: CharactersListComponentFactory,
): ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    val stack = childStack(
        source = navigation,
        initialConfiguration = Config.CharactersListConfig,
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Config,
        componentContext: ComponentContext
    ): Child = when(config) {
        Config.CharactersListConfig -> Child.CharactersListChild(
            charactersListComponentFactory.createComponent(componentContext)
        )
    }

    @Serializable
    sealed class Config {
        @Serializable
        object CharactersListConfig : Config()
    }

    sealed class Child {
        data class CharactersListChild(val component: CharactersListComponent) : Child()
    }
}