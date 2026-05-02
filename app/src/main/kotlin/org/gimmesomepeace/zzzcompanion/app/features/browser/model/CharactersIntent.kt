package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId


sealed interface CharactersIntent {
    // filters bar
    data class SetQuery(val query: String) : CharactersIntent
    data class SetFaction(val factionId: FactionId?) : CharactersIntent
    data class SetSpeciality(val specialityId: SpecialityId?) : CharactersIntent
    data class SetAttribute(val attributeId: AttributeId?) : CharactersIntent
    data class SetRarity(val rarityId: RarityId?) : CharactersIntent

    data class AddCharacter(val characterId: CharacterId) : CharactersIntent
}