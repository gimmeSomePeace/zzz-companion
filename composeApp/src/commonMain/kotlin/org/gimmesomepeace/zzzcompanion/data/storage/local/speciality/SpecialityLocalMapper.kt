package org.gimmesomepeace.zzzcompanion.data.storage.local.speciality

import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


fun SpecialityLocalEntity.toDomain() : Speciality = Speciality(
    id = SpecialityId(id),
    name = name,
    imageUrl = imageUrl,
)

fun List<SpecialityLocalEntity>.toDomain() : List<Speciality> = this.map { it.toDomain() }
