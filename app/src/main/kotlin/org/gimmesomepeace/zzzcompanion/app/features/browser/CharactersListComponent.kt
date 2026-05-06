package org.gimmesomepeace.zzzcompanion.app.features.browser

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId


class CharactersListComponent (
    private val componentContext: ComponentContext,
    private val charactersStore: CharactersStore,
    private val onCharacterClicked: (CharacterId) -> Unit,
) : ComponentContext by componentContext {

    val uiState: StateFlow<CharactersScreenState> = charactersStore.state

    fun onIntent(intent: CharactersIntent) {
        // TODO: Это затычка, не более
        if (intent is CharactersIntent.GoToCharacter) {
            onCharacterClicked(intent.characterId)
        } else charactersStore.onIntent(intent)
    }
}