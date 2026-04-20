package org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter

import org.gimmesomepeace.zzzcompanion.core.model.OwnedCharacter
import org.gimmesomepeace.zzzcompanion.core.model.OwnedCharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId


fun OwnedCharacterLocalEntity.toDomain() : OwnedCharacter = OwnedCharacter(
    id = OwnedCharacterId(id),
    characterId = CharacterId(characterId),
    disks = disks
)

fun List<OwnedCharacterLocalEntity>.toDomain(): List<OwnedCharacter> = map { it.toDomain() }

fun OwnedCharacter.toLocalEntity() : OwnedCharacterLocalEntity = OwnedCharacterLocalEntity(
    id = id.value,
    characterId = characterId.value,
    disks = disks
)
