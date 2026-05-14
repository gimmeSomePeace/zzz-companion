package org.gimmesomepeace.zzzcompanion.core.disktype

import java.net.URI


/**
 * Тип диска
 *
 * @property imageUri URI изображения типа диска
 */
@ConsistentCopyVisibility
data class DiskType private constructor(
    val id: DiskTypeId,
    val name: String,
    val imageUri: URI
) {
    companion object {
        fun create(
            id: DiskTypeId,
            name: String,
            imageUri: URI
        ): DiskType {
            require(!name.isBlank()) { "Name must not be blank." }
            return DiskType(id, name, imageUri)
        }
    }
}
