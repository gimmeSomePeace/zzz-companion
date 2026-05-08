package org.gimmesomepeace.zzzcompanion.core.disktype

import java.net.URI


/**
 * Референсная сущность вида диска.
 *
 * Используется лишь для отображения в UI.
 */
data class DiskType (
    val id: DiskTypeId,
    val name: String,
    val imageUrl: URI
)
