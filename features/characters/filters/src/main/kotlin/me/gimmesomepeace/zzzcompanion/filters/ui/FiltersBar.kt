package me.gimmesomepeace.zzzcompanion.filters.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.debounce
import me.gimmesomepeace.uikit.select.LabeledSelect
import me.gimmesomepeace.zzzcompanion.filters.FilterComponent
import me.gimmesomepeace.zzzcompanion.filters.FiltersIntent

@Composable
fun FiltersBar(component: FilterComponent) {
    val state by component.state.collectAsState()
    var localQuery by remember { mutableStateOf("") }

    LaunchedEffect(localQuery) {
        snapshotFlow { localQuery }
            .debounce(300)
            .collect {
                component.onIntent(FiltersIntent.SetQuery(it))
            }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        LabeledSelect(
            "Rarity",
            state.rarities,
            state.selectedRarity,
            { component.onIntent(FiltersIntent.SetRarity(it)) },
            modifier = Modifier.weight(1f),
        )
        LabeledSelect(
            "Faction",
            state.factions,
            state.selectedFaction,
            { component.onIntent(FiltersIntent.SetFaction(it)) },
            modifier = Modifier.weight(1f),
        )
        LabeledSelect(
            "Attribute",
            state.attributes,
            state.selectedAttribute,
            { component.onIntent(FiltersIntent.SetAttribute(it)) },
            modifier = Modifier.weight(1f),
        )
        LabeledSelect(
            "Speciality",
            state.specialities,
            state.selectedSpeciality,
            { component.onIntent(FiltersIntent.SetSpeciality(it)) },
            modifier = Modifier.weight(1f),
        )
        Box(Modifier.weight(2f)) {
            TextField(
                value = localQuery,
                onValueChange = { localQuery = it },
                placeholder = { Text("Search...") },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                singleLine = true,
            )
        }
    }
}
