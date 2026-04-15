package org.gimmesomepeace.zzzcompanion.features.characters.data.entities


@JvmInline
value class FactionId(val value: String)

data class Faction (
    val id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId,
    val name: String,
    val imageUrl: String
)
