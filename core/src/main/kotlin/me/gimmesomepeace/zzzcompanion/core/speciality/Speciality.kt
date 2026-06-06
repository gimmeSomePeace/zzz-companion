package me.gimmesomepeace.zzzcompanion.core.speciality

import java.net.URI

/**
 * Специализация (например: защита, разрушение, аномалия и т.д.).
 *
 * @property id Уникальный идентификатор.
 * @property name Наименование.
 * @property imageUri URI изображения эмблемы специализации.
 */
@ConsistentCopyVisibility
data class Speciality private constructor(
    val id: SpecialityId,
    val name: String,
    val imageUri: URI,
) {
    companion object {
        /**
         * Создает специализацию, проверяя инварианты.
         *
         * @param id Идентификатор специализации.
         * @param name Наименование.
         * @param imageUri URI изображения.
         */
        fun create(
            id: SpecialityId,
            name: String,
            imageUri: URI,
        ): Speciality {
            val trimmedName = name.trim()

            require(trimmedName.isNotBlank()) { "Name must not be blank" }
            return Speciality(id, trimmedName, imageUri)
        }
    }
}
