package org.gimmesomepeace.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId

class SpecialityRepository {
    private val _specialities = MutableStateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality>>(emptyList())
    val specialities: StateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality>> = _specialities.asStateFlow()

    init {
        _specialities.value = listOf(
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId("1"),
                "Anomaly",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d2/Icon_Anomaly.png/revision/latest/scale-to-width-down/32?cb=20240704113735"
            ),
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId("2"),
                "Support",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/2/2f/Icon_Support.png/revision/latest/scale-to-width-down/32?cb=20240704113754"
            )
        )
    }

    fun getAll(): List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality> = _specialities.value
    fun getById(id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId): org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Speciality? = _specialities.value.firstOrNull { it.id == id }
}