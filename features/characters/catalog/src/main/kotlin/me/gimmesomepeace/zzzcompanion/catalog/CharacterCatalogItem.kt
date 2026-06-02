package me.gimmesomepeace.zzzcompanion.catalog

import me.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.core.faction.Faction
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.speciality.Speciality
import java.net.URI

data class CharacterCatalogItem(
    val id: CharacterId,
    val name: String,

    val faction: Faction,
    val attribute: Attribute,
    val speciality: Speciality,
    val rarity: Rarity,

    val imageUrl: URI,
    val isOwned: Boolean,
)