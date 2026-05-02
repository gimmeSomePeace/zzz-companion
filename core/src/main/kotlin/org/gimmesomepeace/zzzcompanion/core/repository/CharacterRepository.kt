package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Character
import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterFilters

interface CharacterRepository {
    fun getPage(cursor: String?, limit: Int, filters: CharacterFilters) : Page<Character>
}