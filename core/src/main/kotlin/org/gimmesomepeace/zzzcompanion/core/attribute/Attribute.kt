package org.gimmesomepeace.zzzcompanion.core.attribute

import java.net.URI

/**
 * Атрибут (например: лёд, ветер и т.д.).
 *
 * Инварианты:
 *  - name не может быть пустым или состоять только из пробелов
 *
 * @property imageUri URI изображения атрибута
 */
@ConsistentCopyVisibility
data class Attribute private constructor(
    val id: AttributeId,
    val name: String,
    val imageUri: URI,
) {
    companion object {
        fun create(id: AttributeId, name: String, imageUri: URI): Attribute {
            val trimmedName = name.trim()

            require(trimmedName.isNotBlank()) { "Name must not be blank" }
            return Attribute(id, trimmedName, imageUri)
        }
    }
}
