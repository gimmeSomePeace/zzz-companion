package org.gimmesomepeace.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Rarity
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character


data class ReferenceData(
    val characters: List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character> = emptyList(),
    val factions: List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Faction> = emptyList(),
    val attributes: List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Attribute> = emptyList(),
    val specialities: List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality> = emptyList(),
    val rarities: List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Rarity> = emptyList()
)

class ReferenceRepository(
    characterRepository: org.gimmesomepeace.zzzcompanion.features.characters.data.repository.CharacterRepository,
    factionRepository: org.gimmesomepeace.zzzcompanion.features.characters.data.repository.FactionRepository,
    attributeRepository: org.gimmesomepeace.zzzcompanion.features.characters.data.repository.AttributeRepository,
    specialityRepository: org.gimmesomepeace.zzzcompanion.features.characters.data.repository.SpecialityRepository,
    rarityRepository: org.gimmesomepeace.zzzcompanion.features.characters.data.repository.RarityRepository
) {
    val referenceData: StateFlow<org.gimmesomepeace.zzzcompanion.features.characters.data.repository.ReferenceData> = combine(
        characterRepository.characters,
        factionRepository.factions,
        attributeRepository.attributes,
        specialityRepository.specialities,
        rarityRepository.rarities
    ) { characters, factions, attributes, specialities, rarities ->
        _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.repository.ReferenceData(
            characters,
            factions,
            attributes,
            specialities,
            rarities
        )
    }.stateIn(
        CoroutineScope(Dispatchers.Default + SupervisorJob()),
        SharingStarted.Lazily,
        _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.repository.ReferenceData()
    )
}