package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.uikit.select.SelectOption
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

data class CharactersScreenState(
    val characters: List<CharacterListItemUi>,

    val factionOptions: List<SelectOption<FactionId>>,
    val selectedFactionOption: SelectOption<FactionId>,

    val attributeOptions: List<SelectOption<AttributeId>>,
    val selectedAttributeOption: SelectOption<AttributeId>,

    val specialityOptions: List<SelectOption<SpecialityId>>,
    val selectedSpecialityOption: SelectOption<SpecialityId>,

    val rarityOptions: List<SelectOption<Rarity>>,
    val selectedRarityOption: SelectOption<Rarity>,
)
