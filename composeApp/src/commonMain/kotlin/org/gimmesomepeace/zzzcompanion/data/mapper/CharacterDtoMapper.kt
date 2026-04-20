package org.gimmesomepeace.zzzcompanion.data.mapper

import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.model.id.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.id.FactionId
import org.gimmesomepeace.zzzcompanion.core.model.id.RarityId
import org.gimmesomepeace.zzzcompanion.core.model.id.SpecialityId
import org.gimmesomepeace.zzzcompanion.data.storage.local.character.CharacterLocalEntity
import org.gimmesomepeace.zzzcompanion.features.browser.model.CharacterListItem


fun CharacterLocalEntity.toListItem() : CharacterListItem = CharacterListItem(
    id = CharacterId(id),
    name = name,
    imageUrl = imageUrl,

    factionId = FactionId(id),
    attributeId = AttributeId(id),
    specialityId = SpecialityId(id),
    rarityId = RarityId(id),

    isOwned = false
)

fun List<CharacterLocalEntity>.toListItem() : List<CharacterListItem> = this.map { it.toListItem() }
