package org.gimmesomepeace.zzzcompanion.features.browser.presentation.model

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


sealed interface CharactersIntent {
    // filters bar
    data class SetQuery(val query: String) : CharactersIntent
    data class SetFaction(val factionId: FactionId?) : CharactersIntent
    data class SetSpeciality(val specialityId: SpecialityId?) : CharactersIntent
    data class SetAttribute(val attributeId: AttributeId?) : CharactersIntent
    data class SetRarity(val rarityId: RarityId?) : CharactersIntent

    data class AddCharacter(val characterId: CharacterId) : CharactersIntent
}