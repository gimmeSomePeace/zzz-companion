package org.gimmesomepeace.zzzcompanion.data.storage.local.faction

import org.gimmesomepeace.zzzcompanion.core.model.Faction
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import java.util.UUID


fun FactionLocalEntity.toDomain(): Faction = Faction(
    id = FactionId(UUID.fromString(id)),
    name = name,
    imageUrl = imageUrl,
)

fun List<FactionLocalEntity>.toDomain(): List<Faction> = this.map { it.toDomain() }
