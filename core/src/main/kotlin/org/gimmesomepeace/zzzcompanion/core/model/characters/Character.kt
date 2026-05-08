package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.*
import java.net.URI

/**
 * Референсное описание персонажа.
 *
 * Представляет собой неизменную доменную сущность, описывающая информацию о персонаже.
 *
 */
data class Character(
    val id: CharacterId,
    val name: String,

    val factionId: FactionId,
    val attributeId: AttributeId,
    val specialityId: SpecialityId,
    val rarityId: RarityId,

    val imageUrl: URI
)
