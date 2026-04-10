package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.Attribute
import org.zzzcompanion.features.characters.data.entities.AttributeId


class AttributeRepository {
    private val _attributes = MutableStateFlow<List<Attribute>>(emptyList())
    val attributes: StateFlow<List<Attribute>> = _attributes.asStateFlow()

    init {
        _attributes.value = listOf(
            Attribute(
                AttributeId("1"),
                "Physical",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902"
            ),
            Attribute(
                AttributeId("2"),
                "Ice",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955"
            )
        )
    }

    fun getAll(): List<Attribute> = _attributes.value
    fun getById(id: AttributeId): Attribute? = _attributes.value.firstOrNull { it.id == id }
}