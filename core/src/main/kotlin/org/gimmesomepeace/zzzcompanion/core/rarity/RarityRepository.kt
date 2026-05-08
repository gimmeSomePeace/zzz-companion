package org.gimmesomepeace.zzzcompanion.core.rarity


interface RarityRepository {
    fun getAll(): List<Rarity>
}