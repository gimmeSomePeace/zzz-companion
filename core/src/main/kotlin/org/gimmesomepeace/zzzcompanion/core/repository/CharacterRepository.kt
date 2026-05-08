package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.characters.Character
import org.gimmesomepeace.zzzcompanion.core.model.characters.CharacterFilters


interface CharacterRepository {
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: CharacterFilters?
    ) : Page<Character>
}
