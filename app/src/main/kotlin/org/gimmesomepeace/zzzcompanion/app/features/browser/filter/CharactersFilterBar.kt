package org.gimmesomepeace.zzzcompanion.app.features.browser.filter

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
import org.gimmesomepeace.uikit.select.LabeledSelect
import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

@Composable
fun CharactersFilterBar(
    searchQuery: String,
    selectedFaction: SelectOption<FactionId>,
    selectedRarity: SelectOption<Rarity>,
    selectedAttribute: SelectOption<AttributeId>,
    selectedSpeciality: SelectOption<SpecialityId>,
    onSearchQueryChanged: (String) -> Unit,
    onFactionChanged: (factionId: FactionId?) -> Unit,
    onAttributeChanged: (attributeId: AttributeId?) -> Unit,
    onSpecialityChanged: (specialityId: SpecialityId?) -> Unit,
    onRarityChanged: (rarity: Rarity?) -> Unit,
    factions: List<SelectOption<FactionId>>,
    attributes: List<SelectOption<AttributeId>>,
    specialities: List<SelectOption<SpecialityId>>,
    rarities: List<SelectOption<Rarity>>,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LabeledSelect(
            "Rarity",
            rarities,
            selectedRarity,
            onRarityChanged,
            modifier = Modifier.weight(1f)
        )
        LabeledSelect(
            "Faction",
            factions,
            selectedFaction,
            onFactionChanged,
            modifier = Modifier.weight(1f)
        )
        LabeledSelect(
            "Attribute",
            attributes,
            selectedAttribute,
            onAttributeChanged,
            modifier = Modifier.weight(1f)
        )
        LabeledSelect(
            "Speciality",
            specialities,
            selectedSpeciality,
            onSpecialityChanged,
            modifier = Modifier.weight(1f)
        )
        Box(Modifier.weight(2f)) {
            TextField(
                value = searchQuery,
                onValueChange = onSearchQueryChanged,
                placeholder = { Text("Search...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                singleLine = true
            )
        }
    }
}
