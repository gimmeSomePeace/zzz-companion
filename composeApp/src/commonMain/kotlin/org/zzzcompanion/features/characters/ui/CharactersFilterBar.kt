package org.zzzcompanion.features.characters.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.zzzcompanion.core.ui.EmptyItem
import org.zzzcompanion.core.ui.FilterItem
import org.zzzcompanion.core.ui.LabeledSelect
import org.zzzcompanion.features.characters.data.entities.Attribute
import org.zzzcompanion.features.characters.data.entities.Faction
import org.zzzcompanion.features.characters.data.entities.Rarity
import org.zzzcompanion.features.characters.data.entities.Speciality


@Composable
fun CharactersFilterBar(
    searchQuery: String,
    selectedFaction: Faction?,
    selectedRarity: Rarity?,
    selectedAttribute: Attribute?,
    selectedSpeciality: Speciality?,

    onSearchQueryChanged: (String) -> Unit,
    onFactionChanged: (factionId: Long?) -> Unit,
    onAttributeChanged: (attributeId: Long?) -> Unit,
    onSpecialityChanged: (specialityId: Long?) -> Unit,
    onRarityChanged: (rarityId: Long?) -> Unit,

    factions: List<Faction?>,
    attributes: List<Attribute?>,
    specialities: List<Speciality?>,
    rarities: List<Rarity?>
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        LabeledSelect(
            "Rarity",
            rarities,
            selectedRarity,
            { onRarityChanged(it?.id) },
            { item ->
                if (item == null) EmptyItem() else FilterItem(
                    item.name,
                    item.imageUrl
                )
            },
            modifier = Modifier.weight(1f),
        )
        LabeledSelect(
            "Faction",
            factions,
            selectedFaction,
            { onFactionChanged(it?.id) },
            { item ->
                if (item == null) EmptyItem() else FilterItem(
                    item.name,
                    item.imageUrl
                )
            },
            modifier = Modifier.weight(1f),
        )
        LabeledSelect(
            "Attribute",
            attributes,
            selectedAttribute,
            { onAttributeChanged(it?.id) },
            { item ->
                if (item == null) EmptyItem() else FilterItem(
                    item.name,
                    item.imageUrl
                )
            },
            modifier = Modifier.weight(1f),
        )
        LabeledSelect(
            "Speciality",
            specialities,
            selectedSpeciality,
            { onSpecialityChanged(it?.id) },
            { item ->
                if (item == null) EmptyItem() else FilterItem(
                    item.name,
                    item.imageUrl
                )
            },
            modifier = Modifier.weight(1f),
        )
        TextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            placeholder = { androidx.compose.material3.Text("Search...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(2f),
            singleLine = true,
        )
    }
}
