package org.gimmesomepeace.zzzcompanion.domain.model.character


@JvmInline
value class SpecialityId(val value: String)

data class Speciality(
    val id: SpecialityId,
    val name: String,
    val imageUrl: String
)
