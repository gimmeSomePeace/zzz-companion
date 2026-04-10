package org.zzzcompanion.features.characters.data.entities


@JvmInline
value class SpecialityId(val value: String)

data class Speciality(
    val id: SpecialityId,
    val name: String,
    val imageUrl: String
)
