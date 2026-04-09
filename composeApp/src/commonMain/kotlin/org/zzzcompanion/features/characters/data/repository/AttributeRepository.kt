package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.Attribute


class AttributeRepository {
    private val _attributes = MutableStateFlow<List<Attribute>>(emptyList())
    val attributes: StateFlow<List<Attribute>> = _attributes.asStateFlow()

    init {
        _attributes.value = listOf(
            Attribute(
                1,
                "Physical",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902"
            ),
            Attribute(
                2,
                "Ice",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955"
            )
        )
    }

    fun getAll(): List<Attribute> = _attributes.value
    fun getById(id: Long): Attribute? = _attributes.value.firstOrNull { it.id == id }
}