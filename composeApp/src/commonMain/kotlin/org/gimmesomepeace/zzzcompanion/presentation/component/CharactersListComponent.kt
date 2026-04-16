package org.gimmesomepeace.zzzcompanion.presentation.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow


class CharactersListComponent (
    private val componentContext: ComponentContext,
    private val charactersStore: CharactersStore
) : ComponentContext by componentContext {

    val uiState: StateFlow<CharactersScreenState> = charactersStore.state

    fun onIntent(intent: CharactersIntent) {
        charactersStore.onIntent(intent)
    }
}