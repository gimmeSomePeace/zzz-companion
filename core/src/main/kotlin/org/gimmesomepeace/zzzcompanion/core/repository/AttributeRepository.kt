package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Attribute


interface AttributeRepository {
    fun getAll(): List<Attribute>
}