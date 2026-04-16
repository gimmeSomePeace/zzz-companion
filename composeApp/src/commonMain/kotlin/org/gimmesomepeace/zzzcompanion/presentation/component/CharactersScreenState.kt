package org.gimmesomepeace.zzzcompanion.presentation.component

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality
import org.gimmesomepeace.zzzcompanion.presentation.filter.FiltersStateUi
import org.gimmesomepeace.zzzcompanion.presentation.model.character.CharacterUi


data class CharactersScreenState (
    val filters: FiltersStateUi,

    val characters: List<CharacterUi>,
    val factionOptions: List<Faction?>,
    val attributeOptions: List<Attribute?>,
    val specialityOptions: List<Speciality?>,
    val rarityOptions: List<Rarity?>
)
