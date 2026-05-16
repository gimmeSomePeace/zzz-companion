package org.gimmesomepeace.zzzcompanion.core.diskset

import java.net.URI

/**
 * Комплект драйв-дисков
 *
 * @property id Уникальный Идентификатор
 * @property name Имя
 * @property imageUri URI изображения комплекта драйв-дисков
 */
@ConsistentCopyVisibility
data class DriveDiskSet private constructor(
    val id: DriveDiskSetId,
    val name: String,
    val imageUri: URI,
) {
    companion object {
        fun create(id: DriveDiskSetId, name: String, imageUri: URI): DriveDiskSet {
            require(!name.isBlank()) { "Name must not be blank." }
            return DriveDiskSet(id, name, imageUri)
        }
    }
}
