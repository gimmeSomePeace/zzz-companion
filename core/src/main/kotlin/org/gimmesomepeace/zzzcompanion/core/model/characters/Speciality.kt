package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId
import java.net.URI


data class Speciality(
    val id: SpecialityId,
    val name: String,
    val imageUrl: URI
)
