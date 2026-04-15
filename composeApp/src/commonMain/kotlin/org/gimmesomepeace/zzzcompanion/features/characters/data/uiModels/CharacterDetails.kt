package org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels

import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Rarity
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality

data class CharacterDetails(
    val id: CharacterId,
    val name: String,

    val faction: Faction?,
    val attribute: Attribute?,
    val speciality: Speciality?,
    val rarity: Rarity?,

    val imageUrl: String,
)
