package org.gimmesomepeace.zzzcompanion.data.storage.local.faction

import org.gimmesomepeace.zzzcompanion.domain.model.character.Faction
import org.gimmesomepeace.zzzcompanion.domain.model.character.FactionId


fun FactionLocalEntity.toDomain(): Faction = Faction(
    id = FactionId(id),
    name = name,
    imageUrl = imageUrl,
)

fun List<FactionLocalEntity>.toDomain(): List<Faction> = this.map { it.toDomain() }
