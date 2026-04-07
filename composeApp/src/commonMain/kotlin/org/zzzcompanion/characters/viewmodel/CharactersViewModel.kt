package org.zzzcompanion.characters.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.zzzcompanion.characters.repository.UserCharacterRepository


class CharacterViewModel : ViewModel() {
    private val allCharacters = UserCharacterRepository.getAll()

    var filteredCharacters by mutableStateOf(allCharacters)
        private set

    var searchQuery by mutableStateOf("")
        private set

    fun onSearchQueryChanged(newQuery: String) {
        searchQuery = newQuery
        filteredCharacters = if (newQuery.isBlank()) {
            allCharacters
        } else {
            allCharacters.filter {it.character.name.contains(newQuery, true) }
        }
    }
}
