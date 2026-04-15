package org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels

import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Rarity
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality
import org.gimmesomepeace.zzzcompanion.features.characters.ui.CharacterUi


sealed interface CharactersScreenState {
    val filters: CharactersFilterDetails
    val factionOptions: List<Faction?>
    val attributeOptions: List<Attribute?>
    val specialityOptions: List<Speciality?>
    val rarityOptions: List<Rarity?>

    data class Loading(
        override val filters: CharactersFilterDetails,
        override val factionOptions: List<Faction?>,
        override val attributeOptions: List<Attribute?>,
        override val specialityOptions: List<Speciality?>,
        override val rarityOptions: List<Rarity?>
    ): CharactersScreenState

    data class Content(
        val characterItems: List<CharacterUi>,

        override val factionOptions: List<Faction?>,
        override val attributeOptions: List<Attribute?>,
        override val specialityOptions: List<Speciality?>,
        override val rarityOptions: List<Rarity?>,

        override val filters: CharactersFilterDetails
    ): CharactersScreenState
}