package org.zzzcompanion.characters.repository

import org.zzzcompanion.characters.model.Speciality

object SpecialityRepository {
    private val specialities = listOf(
        Speciality("Anomaly", "https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d2/Icon_Anomaly.png/revision/latest/scale-to-width-down/32?cb=20240704113735"),
        Speciality("Support", "https://static.wikia.nocookie.net/zenless-zone-zero/images/2/2f/Icon_Support.png/revision/latest/scale-to-width-down/32?cb=20240704113754")
    )

    fun getAll(): List<Speciality> = specialities
}