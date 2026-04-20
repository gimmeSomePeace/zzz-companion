package org.gimmesomepeace.zzzcompanion.features.browser.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.gimmesomepeace.zzzcompanion.core.ui.EmptyItem
import org.gimmesomepeace.zzzcompanion.core.ui.FilterItem
import org.gimmesomepeace.zzzcompanion.core.ui.LabeledSelect
import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


@Composable
fun CharactersFilterBar(
    searchQuery: String,
    selectedFaction: Faction?,
    selectedRarity: Rarity?,
    selectedAttribute: Attribute?,
    selectedSpeciality: Speciality?,

    onSearchQueryChanged: (String) -> Unit,
    onFactionChanged: (factionId: FactionId?) -> Unit,
    onAttributeChanged: (attributeId: AttributeId?) -> Unit,
    onSpecialityChanged: (specialityId: SpecialityId?) -> Unit,
    onRarityChanged: (rarityId: RarityId?) -> Unit,

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
            placeholder = { Text("Search...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(2f),
            singleLine = true,
        )
    }
}
