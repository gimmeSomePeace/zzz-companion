package org.gimmesomepeace.zzzcompanion.features.characters.ui

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
import org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels.CharactersScreenState
import org.gimmesomepeace.zzzcompanion.features.characters.domain.CharactersListComponent


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

            component::onSearchQueryChange,
            component::onFactionChange,
            component::onAttributeChange,
            component::onSpecialityChange,
            component::onRarityChange,

            state.factionOptions,
            state.attributeOptions,
            state.specialityOptions,
            state.rarityOptions,
        )
        Spacer(modifier = Modifier.height(8.dp))

        when (val s = state) {
            is CharactersScreenState.Content -> {
                CharactersList(
                    characters = s.characterItems,
                    onMissingCharacterClick = { characterId ->
                        component.onAction(CharactersAction.Add(characterId))
                })
            }
            is CharactersScreenState.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}
