package org.gimmesomepeace.zzzcompanion.data.storage.local.rarity

import org.gimmesomepeace.zzzcompanion.core.model.Rarity
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import java.util.UUID


fun RarityLocalEntity.toDomain(): Rarity = Rarity(
    id = RarityId(UUID.fromString(id)),
    name = name,
    imageUrl = imageUrl
)

fun List<RarityLocalEntity>.toDomain(): List<Rarity> = this.map { it.toDomain() }
