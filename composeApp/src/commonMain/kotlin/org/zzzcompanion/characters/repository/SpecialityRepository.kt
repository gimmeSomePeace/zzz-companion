package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.Speciality

class SpecialityRepository {
    private val specialities = listOf(
        Speciality(1, "Anomaly", "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d2/Icon_Anomaly.png/revision/latest/scale-to-width-down/32?cb=20240704113735"),
        Speciality(2, "Support", "https://static.wikia.nocookie.net/zenless-zone-zero/images/2/2f/Icon_Support.png/revision/latest/scale-to-width-down/32?cb=20240704113754")
    )

    fun getAll(): List<Speciality> = specialities
    fun getById(id: Long): Speciality? = specialities.firstOrNull { it.id == id }
}