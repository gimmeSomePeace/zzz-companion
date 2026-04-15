package org.gimmesomepeace.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId


class AttributeRepository {
    private val _attributes = MutableStateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute>>(emptyList())
    val attributes: StateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute>> = _attributes.asStateFlow()

    init {
        _attributes.value = listOf(
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId("1"),
                "Physical",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902"
            ),
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId("2"),
                "Ice",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955"
            )
        )
    }

    fun getAll(): List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute> = _attributes.value
    fun getById(id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId): org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute? = _attributes.value.firstOrNull { it.id == id }
}