package org.gimmesomepeace.zzzcompanion.presentation.component

import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId


sealed interface CharactersIntent {
    // filters bar
    data class SetQuery(val query: String) : CharactersIntent
    data class SetFaction(val factionId: FactionId?) : CharactersIntent
    data class SetSpeciality(val specialityId: SpecialityId?) : CharactersIntent
    data class SetAttribute(val attributeId: AttributeId?) : CharactersIntent
    data class SetRarity(val rarityId: RarityId?) : CharactersIntent

    data class AddCharacter(val characterId: CharacterId) : CharactersIntent
}