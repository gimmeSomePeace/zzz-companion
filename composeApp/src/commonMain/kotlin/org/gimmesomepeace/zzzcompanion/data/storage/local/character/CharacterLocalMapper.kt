package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import org.gimmesomepeace.zzzcompanion.core.model.Character
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import java.util.UUID

fun CharacterLocalEntity.toDomain(): Character = Character(
    id = CharacterId(UUID.fromString(id)),
    name = name,
    imageUrl = imageUrl,

    factionId = FactionId(UUID.fromString(factionId)),
    specialityId = SpecialityId(UUID.fromString(specialityId)),
    rarityId = RarityId(UUID.fromString(rarityId)),
    attributeId = AttributeId(UUID.fromString(attributeId)),
)

fun List<CharacterLocalEntity>.toDomain(): List<Character> = map { it.toDomain() }
