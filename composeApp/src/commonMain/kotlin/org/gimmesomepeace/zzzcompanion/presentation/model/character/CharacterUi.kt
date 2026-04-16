package org.gimmesomepeace.zzzcompanion.presentation.model.character

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.Rarity
import org.gimmesomepeace.zzzcompanion.domain.model.character.Speciality

data class CharacterUi(
    val id: CharacterId,
    val name: String,

    val faction: Faction,
    val attribute: Attribute,
    val speciality: Speciality,
    val rarity: Rarity,

    val imageUrl: String,
    val isOwned: Boolean
)
