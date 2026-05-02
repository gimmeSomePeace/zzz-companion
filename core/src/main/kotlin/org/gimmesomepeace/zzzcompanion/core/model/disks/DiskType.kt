package org.gimmesomepeace.zzzcompanion.core.model.disks

import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskTypeId
import java.net.URI


data class DiskType (
    val id: DiskTypeId,
    val name: String,
    val imageUrl: URI
)
