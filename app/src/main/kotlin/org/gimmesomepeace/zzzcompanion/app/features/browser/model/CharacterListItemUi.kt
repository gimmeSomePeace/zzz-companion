package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.faction.Faction
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import java.net.URI

data class CharacterListItemUi(
    val id: CharacterId,
    val name: String,

    val faction: Faction,
    val attribute: Attribute,
    val speciality: Speciality,
    val rarity: Rarity,

    val imageUrl: URI,
    val isOwned: Boolean
)
