package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.gimmesomepeace.uikit.DefaultItem
import org.gimmesomepeace.uikit.FilterItem
import org.gimmesomepeace.uikit.LabeledSelect
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.RarityId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId


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
                if (item == null) DefaultItem() else FilterItem(
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
                if (item == null) DefaultItem() else FilterItem(
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
                if (item == null) DefaultItem() else FilterItem(
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
                if (item == null) DefaultItem() else FilterItem(
                    item.name,
                    item.imageUrl
                )
            },
            modifier = Modifier.weight(1f),
        )
        Box(Modifier.weight(2f)) {
            TextField(
                value = searchQuery,
                onValueChange = onSearchQueryChanged,
                placeholder = { Text("Search...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                singleLine = true,
            )
        }
    }
}
