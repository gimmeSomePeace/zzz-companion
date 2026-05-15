package org.gimmesomepeace.zzzcompanion.app.features.browser.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.debounce
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.app.features.browser.filter.CharactersFilterBar
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharactersIntent

@Composable
fun CharactersScreen(component: CharactersListComponent) {
    val state by component.uiState.collectAsStateWithLifecycle()
    var localQuery by remember { mutableStateOf("") }

    LaunchedEffect(localQuery) {
        snapshotFlow { localQuery }
            .debounce(300)
            .collect {
                component.onIntent(CharactersIntent.SetQuery(it))
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CharactersFilterBar(
            localQuery,
            state.selectedFactionOption,
            state.selectedRarityOption,
            state.selectedAttributeOption,
            state.selectedSpecialityOption,

            onSearchQueryChanged = { localQuery = it },
            { component.onIntent(CharactersIntent.SetFaction(it)) },
            { component.onIntent(CharactersIntent.SetAttribute(it)) },
            { component.onIntent(CharactersIntent.SetSpeciality(it)) },
            { component.onIntent(CharactersIntent.SetRarity(it)) },

            state.factionOptions,
            state.attributeOptions,
            state.specialityOptions,
            state.rarityOptions
        )
        Spacer(modifier = Modifier.height(8.dp))

        CharactersList(
            characters = state.characters,
            onMissingCharacterClick = { characterId ->
                component.onIntent(CharactersIntent.AddCharacter(characterId))
            }
        )
    }
}
