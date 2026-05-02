package org.gimmesomepeace.zzzcompanion.app.features.browser.model

import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.ids.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId
import java.net.URI

data class CharacterListItem(
    val id: CharacterId,
    val name: String,

    val factionId: FactionId,
    val attributeId: AttributeId,
    val specialityId: SpecialityId,
    val rarityId: RarityId,

    val imageUrl: URI,
    val isOwned: Boolean,
)
