package me.gimmesomepeace.zzzcompanion.core.attribute

import java.net.URI

/**
 * Атрибут (например: лёд, ветер и т.д.).
 *
 * Инварианты:
 *  - name не может быть пустым или состоять только из пробелов
 *
 * @property id Уникальный идентификатор
 * @property name Название
 * @property imageUri URI изображения атрибута
 */
@ConsistentCopyVisibility
data class Attribute private constructor(
    val id: AttributeId,
    val name: String,
    val imageUri: URI,
) {
    companion object {
        /**
         * Создаёт атрибут, проверяя инварианты.
         *
         * @param id Идентификатор атрибута.
         * @param name Название.
         * @param imageUri URI изображения атрибута.
         * @throws IllegalArgumentException если нарушены инварианты.
         */
        fun create(
            id: AttributeId,
            name: String,
            imageUri: URI,
        ): Attribute {
            val trimmedName = name.trim()

            require(trimmedName.isNotBlank()) { "Name must not be blank" }
            return Attribute(id, trimmedName, imageUri)
        }
    }
}
