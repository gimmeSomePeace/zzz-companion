package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Rarity


interface RarityRepository {
    fun getAll(): List<Rarity>
}