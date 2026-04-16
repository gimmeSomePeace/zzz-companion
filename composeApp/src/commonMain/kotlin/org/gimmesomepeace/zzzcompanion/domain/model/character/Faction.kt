package org.gimmesomepeace.zzzcompanion.domain.model.character


@JvmInline
value class FactionId(val value: String)

data class Faction (
    val id: FactionId,
    val name: String,
    val imageUrl: String
)
