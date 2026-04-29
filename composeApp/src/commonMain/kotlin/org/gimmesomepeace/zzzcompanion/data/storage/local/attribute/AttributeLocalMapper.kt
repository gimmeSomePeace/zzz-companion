package org.gimmesomepeace.zzzcompanion.data.storage.local.attribute

import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import java.util.UUID


fun AttributeLocalEntity.toDomain(): Attribute = Attribute(
    id = AttributeId(UUID.fromString(id)),
    name = name,
    imageUrl = imageUrl
)

fun List<AttributeLocalEntity>.toDomain(): List<Attribute> = map { it.toDomain() }
