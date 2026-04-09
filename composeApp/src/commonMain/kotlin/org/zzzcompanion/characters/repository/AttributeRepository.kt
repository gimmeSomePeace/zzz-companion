package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.Attribute


class AttributeRepository {
    private val attributes: List<Attribute> = listOf(
        Attribute(1,"Physical", "https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902"),
        Attribute(2,"Ice", "https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955")
    )

    fun getAll(): List<Attribute> = attributes
    fun getById(id: Long): Attribute? = attributes.firstOrNull { it.id == id }
}