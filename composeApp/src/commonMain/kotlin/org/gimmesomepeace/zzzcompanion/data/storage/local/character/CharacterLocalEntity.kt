package org.gimmesomepeace.zzzcompanion.data.storage.local.character

import java.net.URI

data class CharacterLocalEntity(
    val id: String,
    val name: String,

    val factionId: String,
    val attributeId: String,
    val specialityId: String,
    val rarityId: String,

    val imageUrl: URI,
)