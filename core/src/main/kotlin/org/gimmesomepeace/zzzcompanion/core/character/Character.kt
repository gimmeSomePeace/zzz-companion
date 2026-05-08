package org.gimmesomepeace.zzzcompanion.core.character

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.RarityId
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
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
