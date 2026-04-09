package org.zzzcompanion.features.characters.mappers

import org.zzzcompanion.features.characters.data.entities.Character
import org.zzzcompanion.features.characters.data.entities.UserCharacter
import org.zzzcompanion.features.characters.data.repository.AttributeRepository
import org.zzzcompanion.features.characters.data.repository.CharacterRepository
import org.zzzcompanion.features.characters.data.repository.FactionRepository
import org.zzzcompanion.features.characters.data.repository.RarityRepository
import org.zzzcompanion.features.characters.data.repository.SpecialityRepository
import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.CharactersFilterDetails
import org.zzzcompanion.features.characters.domain.CharactersFilters

class CharacterUiMapper(
    private val factionRepository: FactionRepository,
    private val specialityRepository: SpecialityRepository,
    private val attributeRepository: AttributeRepository,
    private val rarityRepository: RarityRepository,
    private val characterRepository: CharacterRepository
) {
    fun mapToFilterDetails(filters: CharactersFilters): CharactersFilterDetails {
        return CharactersFilterDetails(
            filters.query,
            if (filters.factionId != null) factionRepository.getById(filters.factionId) else null,
            if (filters.attributeId != null) attributeRepository.getById(filters.attributeId) else null,
            if (filters.specialityId != null) specialityRepository.getById(filters.specialityId) else null,
            if (filters.rarityId != null) rarityRepository.getById(filters.rarityId) else null
        )
    }

    fun mapToUserCharacterDetails(userCharacter: UserCharacter): UserCharacterDetails {
        val character = characterRepository.getById(userCharacter.characterId)
        val mappedCharacter = if (character != null) mapToCharacterDetails(character) else null

        return UserCharacterDetails(
            userCharacter.id,
            mappedCharacter,
            userCharacter.disks
        )
    }

    fun mapToCharacterDetails(character: Character): CharacterDetails {
        return CharacterDetails(
            character.id,
            character.name,
            factionRepository.getById(character.factionId),
            attributeRepository.getById(character.attributeId),
            specialityRepository.getById(character.specialityId),
            rarityRepository.getById(character.rarityId),
            character.imageUrl,
        )
    }
}