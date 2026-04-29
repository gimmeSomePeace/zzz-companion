package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import java.net.URI


data class Speciality(
    val id: SpecialityId,
    val name: String,
    val imageUrl: URI
)
