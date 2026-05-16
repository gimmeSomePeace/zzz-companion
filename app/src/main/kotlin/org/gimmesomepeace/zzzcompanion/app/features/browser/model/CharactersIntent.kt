package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

sealed interface CharactersIntent {
    // filters bar
    data class SetQuery(val query: String) : CharactersIntent
    data class SetFaction(val factionId: FactionId?) : CharactersIntent
    data class SetSpeciality(val specialityId: SpecialityId?) : CharactersIntent
    data class SetAttribute(val attributeId: AttributeId?) : CharactersIntent
    data class SetRarity(val rarity: Rarity?) : CharactersIntent

    data class AddCharacter(val characterId: CharacterId) : CharactersIntent
}
