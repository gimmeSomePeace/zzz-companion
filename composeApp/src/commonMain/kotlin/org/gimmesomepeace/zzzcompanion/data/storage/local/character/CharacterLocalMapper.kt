package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import org.gimmesomepeace.zzzcompanion.core.model.Character
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId

fun CharacterLocalEntity.toDomain(): Character = Character(
    id = CharacterId(id),
    name = name,
    imageUrl = imageUrl,

    factionId = FactionId(factionId),
    specialityId = SpecialityId(specialityId),
    rarityId = RarityId(rarityId),
    attributeId = AttributeId(attributeId)
)

fun List<CharacterLocalEntity>.toDomain(): List<Character> = map { it.toDomain() }
