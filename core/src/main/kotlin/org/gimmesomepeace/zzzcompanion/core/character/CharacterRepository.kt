package org.gimmesomepeace.zzzcompanion.core.character

import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize

interface CharacterRepository {
    fun getPage(cursor: String?, pageSize: PageSize = PageSize(10), filters: CharacterFilters?): Page<Character>
}
