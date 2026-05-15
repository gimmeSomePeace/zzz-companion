package org.gimmesomepeace.zzzcompanion.core.speciality

import java.net.URI

/**
 * Специализация (например: защита, разрушение, аномалия и т.д.)
 *
 *
 * @property imageUri URI изображения эмблемы специализации.
 */
@ConsistentCopyVisibility
data class Speciality private constructor(
    val id: SpecialityId,
    val name: String,
    val imageUri: URI
) {
    companion object {
        fun create(
            id: SpecialityId,
            name: String,
            imageUri: URI
        ): Speciality {
            val trimmedName = name.trim()

            require(trimmedName.isNotBlank()) { "Name must not be blank" }
            return Speciality(id, trimmedName, imageUri)
        }
    }
}
