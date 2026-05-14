package org.gimmesomepeace.zzzcompanion.core.disktype

import java.net.URI


/**
 * Тип диска
 *
 * @property imageUri URI изображения типа диска
 */
data class DiskType (
    val id: DiskTypeId,
    val name: String,
    val imageUri: URI
)
