package org.gimmesomepeace.zzzcompanion.data.storage.local.attribute

import org.gimmesomepeace.zzzcompanion.domain.model.character.Attribute
import org.gimmesomepeace.zzzcompanion.domain.model.character.AttributeId


fun AttributeLocalEntity.toDomain(): Attribute = Attribute(
    id = AttributeId(id),
    name = name,
    imageUrl = imageUrl
)

fun List<AttributeLocalEntity>.toDomain(): List<Attribute> = map { it.toDomain() }
