package org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter

import org.gimmesomepeace.zzzcompanion.domain.model.character.CharacterId
import org.gimmesomepeace.zzzcompanion.domain.model.character.OwnedCharacter
import org.gimmesomepeace.zzzcompanion.domain.model.character.OwnedCharacterId


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
