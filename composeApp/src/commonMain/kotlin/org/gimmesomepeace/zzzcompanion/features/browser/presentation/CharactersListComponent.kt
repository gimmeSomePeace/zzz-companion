package org.gimmesomepeace.zzzcompanion.features.browser.presentation

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.features.browser.presentation.model.CharactersScreenState

class CharactersListComponent (
    private val componentContext: ComponentContext,
    private val charactersStore: CharactersStore
) : ComponentContext by componentContext {

    val uiState: StateFlow<CharactersScreenState> = charactersStore.state

    fun onIntent(intent: CharactersIntent) {
        charactersStore.onIntent(intent)
    }
}