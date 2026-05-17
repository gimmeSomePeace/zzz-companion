package org.gimmesomepeace.zzzcompanion.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore

class RootComponent(
    componentContext: ComponentContext,
    val charactersStore: CharactersStore,
): ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    val stack = childStack(
        source = navigation,
        initialConfiguration = Config.CharactersList,
        serializer = Config.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Config,
        componentContext: ComponentContext
    ): Child = when(config) {
        Config.CharactersList -> Child.CharactersList(
            component = CharactersListComponent(
                componentContext,
                charactersStore = charactersStore
            ),
        )
    }

    @Serializable
    sealed class Config {
        @Serializable
        object CharactersList : Config()
    }

    sealed class Child {
        data class CharactersList(val component: CharactersListComponent) : Child()
    }
}