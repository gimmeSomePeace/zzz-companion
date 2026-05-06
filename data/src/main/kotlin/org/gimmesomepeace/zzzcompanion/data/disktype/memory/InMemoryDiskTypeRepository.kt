package org.gimmesomepeace.zzzcompanion.data.disktype.memory

import org.gimmesomepeace.zzzcompanion.core.model.disks.DiskType
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskTypeId
import org.gimmesomepeace.zzzcompanion.core.repository.DiskTypeRepository
import java.net.URI
import java.util.UUID


class InMemoryDiskTypeRepository: DiskTypeRepository {
    private val diskTypes = listOf(
        DiskType(
            DiskTypeId(UUID.fromString("6f9f09fd-f7b9-467a-99c6-6f8795795b91")),
            "Dawn's Bloom",
            URI("https://sunderarmor.com/ZZZ/Drive/1/SuitDawn'sBloom.webp")
        ),
        DiskType(
            DiskTypeId(UUID.fromString("e20dba7f-f17d-4de4-a502-c0d94a71d621")),
            "Swing Jazz",
            URI("https://sunderarmor.com/ZZZ/Drive/1/SuitSwingJazz.webp")
        )
    )

    override fun getById(id: DiskTypeId): DiskType? {
        return diskTypes.find { it.id == id }
    }
}