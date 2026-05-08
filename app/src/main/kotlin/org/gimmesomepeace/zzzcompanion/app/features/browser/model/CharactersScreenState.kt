package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality


data class CharactersScreenState (
    val filters: FiltersStateUi,

    val characters: List<CharacterListItemUi>,
    val factionOptions: List<Faction?>,
    val attributeOptions: List<Attribute?>,
    val specialityOptions: List<Speciality?>,
    val rarityOptions: List<Rarity?>
)
