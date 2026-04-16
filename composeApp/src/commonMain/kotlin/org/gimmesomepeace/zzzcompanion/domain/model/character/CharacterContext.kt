package org.gimmesomepeace.zzzcompanion.domain.model.character


data class CharacterContext(
    val character: Character,
    val ownership: OwnedCharacter?
)
