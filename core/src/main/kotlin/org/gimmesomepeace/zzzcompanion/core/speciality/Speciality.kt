package org.gimmesomepeace.zzzcompanion.core.speciality

import java.net.URI

/**
 * Референсное описание специализации персонажа.
 *
 * У одного персонажа может быть лишь одна специализация (Устрашение, аномалия и т.д.)
 * В логике на уровне проекта не используется. Это лишь референсный тип.
 *
 * @property imageUri URL картинки с изображением специализации.
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
            require(name.isNotBlank()) { "Name must not be blank" }
            return Speciality(id, name, imageUri)
        }
    }
}
