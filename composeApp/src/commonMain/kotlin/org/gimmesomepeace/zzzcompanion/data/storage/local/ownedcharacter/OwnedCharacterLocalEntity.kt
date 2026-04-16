package org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter


data class OwnedCharacterLocalEntity(
    val id: String,
    val characterId: String,
    val disks: List<String>
)
