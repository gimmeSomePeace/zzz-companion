package org.zzzcompanion.features.characters.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.zzzcompanion.features.characters.data.uiModels.CharactersScreenState
import org.zzzcompanion.features.characters.domain.CharactersListComponent


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

            component::onSearchQueryChanged,
            component::onFactionChanged,
            component::onAttributeChanged,
            component::onSpecialityChanged,
            component::onRarityChanged,

            state.factionOptions,
            state.attributeOptions,
            state.specialityOptions,
            state.rarityOptions,
        )
        Spacer(modifier = Modifier.height(8.dp))

        when (val s = state) {
            is CharactersScreenState.Content -> {
                CharactersList(s.characterItems, component::onAddCharacter)
            }
            is CharactersScreenState.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}
