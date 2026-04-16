package org.gimmesomepeace.zzzcompanion.presentation.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import org.gimmesomepeace.zzzcompanion.presentation.ui.character.CharactersAction


class CharactersListComponent (
    private val componentContext: ComponentContext,
    private val actionHandler: CharactersActionHandler,
    private val charactersStore: CharactersStore
) : ComponentContext by componentContext {

    val uiState: StateFlow<CharactersScreenState> = charactersStore.state

    fun onAction(action: CharactersAction) {
        actionHandler.handle(action)
    }

    fun onIntent(intent: CharactersIntent) {
        charactersStore.onIntent(intent)
    }
}