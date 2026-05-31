package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.shared.Filter

data class CharacterUserDataFilters(val query: String? = null) : Filter<CharacterUserData> {
    override fun toPredicate(): (CharacterUserData) -> Boolean = { true }
}
