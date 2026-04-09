package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.zzzcompanion.features.characters.data.entities.Attribute
import org.zzzcompanion.features.characters.data.entities.Faction
import org.zzzcompanion.features.characters.data.entities.Rarity
import org.zzzcompanion.features.characters.data.entities.Speciality
import org.zzzcompanion.features.characters.data.entities.Character


data class ReferenceData(
    val characters: List<Character> = emptyList(),
    val factions: List<Faction> = emptyList(),
    val attributes: List<Attribute> = emptyList(),
    val specialities: List<Speciality> = emptyList(),
    val rarities: List<Rarity> = emptyList()
)

class ReferenceRepository(
    characterRepository: CharacterRepository,
    factionRepository: FactionRepository,
    attributeRepository: AttributeRepository,
    specialityRepository: SpecialityRepository,
    rarityRepository: RarityRepository
) {
    val referenceData: StateFlow<ReferenceData> = combine(
        characterRepository.characters,
        factionRepository.factions,
        attributeRepository.attributes,
        specialityRepository.specialities,
        rarityRepository.rarities
    ) { characters, factions, attributes, specialities, rarities ->
        ReferenceData(
            characters,
            factions,
            attributes,
            specialities,
            rarities
        )
    }.stateIn(
        CoroutineScope(Dispatchers.Default + SupervisorJob()),
        SharingStarted.Lazily,
        ReferenceData()
    )
}