package org.gimmesomepeace.zzzcompanion.data.storage.local.faction

import java.net.URI


data class FactionLocalEntity(
    val id: String,
    val name: String,
    val imageUrl: URI
)
