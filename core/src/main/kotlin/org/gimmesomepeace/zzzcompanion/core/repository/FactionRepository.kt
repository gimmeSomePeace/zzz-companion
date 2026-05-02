package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Faction


interface FactionRepository {
    fun getAll() : List<Faction>
}