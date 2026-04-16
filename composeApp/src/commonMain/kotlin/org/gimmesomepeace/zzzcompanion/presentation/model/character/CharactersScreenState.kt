package org.gimmesomepeace.zzzcompanion.presentation.model.character

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality
import org.gimmesomepeace.zzzcompanion.presentation.filter.FiltersStateUi


data class CharactersScreenState (
    val filters: FiltersStateUi,

    val characters: List<CharacterUi>,
    val factionOptions: List<Faction?>,
    val attributeOptions: List<Attribute?>,
    val specialityOptions: List<Speciality?>,
    val rarityOptions: List<Rarity?>
)
