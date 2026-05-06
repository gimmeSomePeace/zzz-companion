package org.gimmesomepeace.zzzcompanion.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore
import org.gimmesomepeace.zzzcompanion.app.features.details.DetailsComponent
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId


class RootComponent(
    componentContext: ComponentContext,
    // TODO: сделать адекватный DI
    private val charactersStore: CharactersStore
): ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    val childStack = childStack<Config, Child>(
        source = navigation,
        initialConfiguration = Config.Browser,
        handleBackButton = true,
        childFactory = ::createChild,

        serializer = null
    )

    private fun createChild(config: Config, context: ComponentContext): Child {
        return when (config) {
            is Config.Browser -> Child.List(
                CharactersListComponent(
                    componentContext = context,
                    charactersStore = charactersStore,
                    onCharacterClicked = { id ->
                        navigation.push(Config.CharacterDetails(id))
                    }
                )
            )
            is Config.CharacterDetails -> Child.Details(
                DetailsComponent(
                    componentContext = context,
                    characterId = config.id
                )
            )
        }
    }

    // в реализации
    sealed class Config {
        data object Browser: Config()
        data class CharacterDetails(val id: CharacterId): Config()
    }

    // в интерфейсе
    sealed class Child {
        data class List(val component: CharactersListComponent): Child()
        data class Details(val component: DetailsComponent): Child()
    }
}