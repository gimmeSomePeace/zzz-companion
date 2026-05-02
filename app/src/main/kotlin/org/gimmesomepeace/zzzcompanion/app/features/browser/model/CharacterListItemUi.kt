package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction
import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.characters.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
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
