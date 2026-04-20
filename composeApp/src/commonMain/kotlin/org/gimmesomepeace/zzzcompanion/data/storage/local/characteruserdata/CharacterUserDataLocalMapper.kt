package org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.model.CharacterUserData
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterUserDataId


fun CharacterUserDataLocalEntity.toDomain() : CharacterUserData = CharacterUserData(
    id = CharacterUserDataId(id),
    characterId = CharacterId(characterId),
    disks = listOf()
)

fun List<CharacterUserDataLocalEntity>.toDomain(): List<CharacterUserData> = map { it.toDomain() }

fun CharacterUserData.toLocalEntity() : CharacterUserDataLocalEntity = CharacterUserDataLocalEntity(
    id = id.value,
    characterId = characterId.value,
    disks1Id = disks[0].id,
    disks2Id = disks[1].id,
    disks3Id = disks[2].id,
    disks4Id = disks[3].id,
    disks5Id = disks[4].id,
    disks6Id = disks[5].id,

)
