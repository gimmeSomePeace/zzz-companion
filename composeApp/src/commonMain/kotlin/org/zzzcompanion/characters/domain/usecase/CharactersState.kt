package org.zzzcompanion.characters.domain.usecase

import org.zzzcompanion.characters.model.Character

data class CharactersState(
    val owned: List<Character>,
    val missing: List<Character>
)
