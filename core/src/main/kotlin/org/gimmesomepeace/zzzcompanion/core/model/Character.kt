package org.gimmesomepeace.zzzcompanion.core.model

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import java.net.URI

data class Character(
    val id: org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId,
    val name: String,

    val factionId: org.gimmesomepeace.zzzcompanion.core.model.id.FactionId,
    val attributeId: org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId,
    val specialityId: org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId,
    val rarityId: org.gimmesomepeace.zzzcompanion.core.model.id.RarityId,

    val imageUrl: URI
)
