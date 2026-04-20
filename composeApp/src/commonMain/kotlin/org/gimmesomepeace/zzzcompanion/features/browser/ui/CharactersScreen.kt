package org.gimmesomepeace.zzzcompanion.features.browser.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharactersIntent
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.browser.internal.filter.CharactersFilterBar


@Composable
fun CharactersScreen(component: CharactersListComponent) {
    val state by component.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CharactersFilterBar(
            state.filters.query,
            state.filters.faction,
            state.filters.rarity,
            state.filters.attribute,
            state.filters.speciality,

            { component.onIntent(CharactersIntent.SetQuery(it)) },
            { component.onIntent(CharactersIntent.SetFaction(it)) },
            { component.onIntent(CharactersIntent.SetAttribute(it)) },
            { component.onIntent(CharactersIntent.SetSpeciality(it)) },
            { component.onIntent(CharactersIntent.SetRarity(it)) },

            state.factionOptions,
            state.attributeOptions,
            state.specialityOptions,
            state.rarityOptions,
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
