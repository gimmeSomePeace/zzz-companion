package org.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.zzzcompanion.features.characters.data.entities.Speciality
import org.zzzcompanion.features.characters.data.entities.SpecialityId

class SpecialityRepository {
    private val _specialities = MutableStateFlow<List<Speciality>>(emptyList())
    val specialities: StateFlow<List<Speciality>> = _specialities.asStateFlow()

    init {
        _specialities.value = listOf(
            Speciality(
                SpecialityId("1"),
                "Anomaly",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d2/Icon_Anomaly.png/revision/latest/scale-to-width-down/32?cb=20240704113735"
            ),
            Speciality(
                SpecialityId("2"),
                "Support",
                "https://static.wikia.nocookie.net/zenless-zone-zero/images/2/2f/Icon_Support.png/revision/latest/scale-to-width-down/32?cb=20240704113754"
            )
        )
    }

    fun getAll(): List<Speciality> = _specialities.value
    fun getById(id: SpecialityId): Speciality? = _specialities.value.firstOrNull { it.id == id }
}