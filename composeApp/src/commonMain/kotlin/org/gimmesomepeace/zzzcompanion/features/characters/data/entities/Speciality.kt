package org.gimmesomepeace.zzzcompanion.features.characters.data.entities


@JvmInline
value class SpecialityId(val value: String)

data class Speciality(
    val id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId,
    val name: String,
    val imageUrl: String
)
