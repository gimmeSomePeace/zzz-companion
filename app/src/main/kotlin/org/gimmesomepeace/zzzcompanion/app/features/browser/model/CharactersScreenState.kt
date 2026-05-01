package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.Speciality


data class CharactersScreenState (
    val filters: FiltersStateUi,

    val characters: List<CharacterListItemUi>,
    val factionOptions: List<Faction?>,
    val attributeOptions: List<Attribute?>,
    val specialityOptions: List<Speciality?>,
    val rarityOptions: List<Rarity?>
)
