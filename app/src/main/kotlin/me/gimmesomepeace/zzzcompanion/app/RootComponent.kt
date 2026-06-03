package me.gimmesomepeace.zzzcompanion.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable
import me.gimmesomepeace.zzzcompanion.browser.CharactersBrowserComponent
import me.gimmesomepeace.zzzcompanion.browser.factory.CharactersListComponentFactory
import org.slf4j.LoggerFactory

class RootComponent(
    componentContext: ComponentContext,
    val charactersListComponentFactory: CharactersListComponentFactory,
): ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()
    private val logger = LoggerFactory.getLogger(RootComponent::class.java)

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
            charactersListComponentFactory.createComponent(
                componentContext,
                goToCharacterDetails = {}
            )
        )
    }

    @Serializable
    sealed interface Config {
        @Serializable
        object CharactersListConfig : Config
    }

    sealed interface Child {
        data class CharactersListChild(val component: CharactersBrowserComponent) : Child
    }
}