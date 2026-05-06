package org.gimmesomepeace.zzzcompanion.core.repository

import org.gimmesomepeace.zzzcompanion.core.model.disks.DiskType
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskTypeId


interface DiskTypeRepository {
    fun getById(id: DiskTypeId): DiskType?
}
