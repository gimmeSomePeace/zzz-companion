package org.zzzcompanion.features.characters.presentation

import org.zzzcompanion.features.characters.data.entities.UserCharacter
import org.zzzcompanion.features.characters.data.repository.ReferenceData
import org.zzzcompanion.features.characters.domain.CharactersFilterMatcher
import org.zzzcompanion.features.characters.domain.CharactersFilters
import org.zzzcompanion.features.characters.mappers.toUi
import org.zzzcompanion.features.characters.ui.CharacterUi

class CharactersPresenter(
    private val matcher: CharactersFilterMatcher
) {
    fun present(
        userCharacters: List<UserCharacter>,
        refs: ReferenceData,
        filters: CharactersFilters
    ) : List<CharacterUi> {
        val userCharsIds = userCharacters.map { it.characterId }.toSet()

        val ownedUi = userCharacters.asSequence()
            .filter { uc ->
                val char = refs.characters.find { it.id == uc.characterId } ?: return@filter false
                matcher.matches(char, filters)
            }
            .map { it.toUi(refs) }
            .toList()

        val missingUi = refs.characters.asSequence()
            .filter { it.id !in userCharsIds && matcher.matches(it, filters) }
            .map { it.toUi(refs) }
            .toList()

        val characterItems = buildList {
            addAll(ownedUi.map { CharacterUi.Owned(it) })
            addAll(missingUi.map { CharacterUi.Missing(it) })
        }
        return characterItems
    }
}