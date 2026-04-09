package org.zzzcompanion.features.characters.data.uiModels

import org.zzzcompanion.features.characters.data.entities.Attribute
import org.zzzcompanion.features.characters.data.entities.Faction
import org.zzzcompanion.features.characters.data.entities.Rarity
import org.zzzcompanion.features.characters.data.entities.Speciality


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
        val owned: List<UserCharacterDetails>,
        val missing: List<CharacterDetails>,

        override val factionOptions: List<Faction?>,
        override val attributeOptions: List<Attribute?>,
        override val specialityOptions: List<Speciality?>,
        override val rarityOptions: List<Rarity?>,

        override val filters: CharactersFilterDetails
    ): CharactersScreenState
}