package org.gimmesomepeace.zzzcompanion.app.features.browser

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState

class CharactersListComponent(
    private val componentContext: ComponentContext,
    private val charactersStore: CharactersStore,
) : ComponentContext by componentContext {

    val uiState: StateFlow<CharactersScreenState> = charactersStore.state

    fun onIntent(intent: CharactersIntent) {
        charactersStore.onIntent(intent)
    }
}
