package org.gimmesomepeace.zzzcompanion.app.features.browser

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState

class CharactersListComponent (
    private val componentContext: ComponentContext,
    private val charactersStore: org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore
) : ComponentContext by componentContext {

    val uiState: StateFlow<org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState> = charactersStore.state

    fun onIntent(intent: org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent) {
        charactersStore.onIntent(intent)
    }
}