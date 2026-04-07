package org.zzzcompanion.characters.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.zzzcompanion.characters.model.UserCharacter
import org.zzzcompanion.characters.model.Character
import org.zzzcompanion.characters.repository.UserCharacterRepository


class UserCharactersViewModel {
    var userCharacters by mutableStateOf(emptyList<UserCharacter>())
        private set

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        userCharacters = UserCharacterRepository.getAll()
    }

    fun addCharacter(character: Character) {
        UserCharacterRepository.add(character)
        loadCharacters()
    }
}