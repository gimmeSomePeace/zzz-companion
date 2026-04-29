package org.gimmesomepeace.zzzcompanion.data.storage.local.speciality

import org.gimmesomepeace.zzzcompanion.core.model.Speciality
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import java.util.UUID


fun SpecialityLocalEntity.toDomain() : Speciality = Speciality(
    id = SpecialityId(UUID.fromString(id)),
    name = name,
    imageUrl = imageUrl,
)

fun List<SpecialityLocalEntity>.toDomain() : List<Speciality> = this.map { it.toDomain() }
