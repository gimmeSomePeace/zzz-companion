package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import java.net.URI

data class Character(
    val id: CharacterId,
    val name: String,

    val factionId: FactionId,
    val attributeId: AttributeId,
    val specialityId: SpecialityId,
    val rarityId: RarityId,

    val imageUrl: URI
)
