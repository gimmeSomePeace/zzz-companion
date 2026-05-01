package org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import org.gimmesomepeace.zzzcompanion.core.repository.AttributeRepository
import org.gimmesomepeace.zzzcompanion.core.repository.FactionRepository
import org.gimmesomepeace.zzzcompanion.core.repository.RarityRepository
import org.gimmesomepeace.zzzcompanion.core.repository.SpecialityRepository


class ReferenceAggregator(
    factionRepository: FactionRepository,
    attributeRepository: AttributeRepository,
    specialityRepository: SpecialityRepository,
    rarityRepository: RarityRepository
) {
    val state: StateFlow<ReferenceData> = combine(
        factionRepository.getAll(),
        attributeRepository.getAll(),
        specialityRepository.getAll(),
        rarityRepository.getAll()
    ) { factions, attributes, specialities, rarities ->

        ReferenceData(
            factions = factions,
            attributes = attributes,
            specialities = specialities,
            rarities = rarities,

            factionsById = factions.associateBy { it.id },
            attributesById = attributes.associateBy { it.id },
            specialitiesById = specialities.associateBy { it.id },
            raritiesById = rarities.associateBy { it.id }
        )
    }.stateIn(
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Default),
        started = SharingStarted.Eagerly,
        initialValue = ReferenceData()
    )
}