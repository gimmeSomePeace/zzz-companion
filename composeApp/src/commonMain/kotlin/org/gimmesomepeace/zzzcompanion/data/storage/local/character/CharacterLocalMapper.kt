package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId
import org.gimmesomepeace.zzzcompanion.domain.model.character.Character
import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId
import org.gimmesomepeace.zzzcompanion.domain.model.character.RarityId
import org.gimmesomepeace.zzzcompanion.domain.model.character.SpecialityId


fun CharacterLocalEntity.toDomain() : Character = Character(
    id = CharacterId(id),
    name = name,
    imageUrl = imageUrl,

    factionId = FactionId(id),
    attributeId = AttributeId(id),
    specialityId = SpecialityId(id),
    rarityId = RarityId(id),
)

fun List<CharacterLocalEntity>.toDomain() : List<Character> = this.map { it.toDomain() }
