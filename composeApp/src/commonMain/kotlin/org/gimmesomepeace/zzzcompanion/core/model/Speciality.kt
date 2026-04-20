package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId


data class Speciality(
    val id: SpecialityId,
    val name: String,
    val imageUrl: String
)
