package org.gimmesomepeace.zzzcompanion.data.disk.memory

import org.gimmesomepeace.zzzcompanion.core.model.disks.Disk
import org.gimmesomepeace.zzzcompanion.core.model.disks.MainStatSlot
import org.gimmesomepeace.zzzcompanion.core.model.disks.MainStatValue
import org.gimmesomepeace.zzzcompanion.core.model.disks.Position
import org.gimmesomepeace.zzzcompanion.core.model.disks.StatType
import org.gimmesomepeace.zzzcompanion.core.model.disks.SubStatSlot
import org.gimmesomepeace.zzzcompanion.core.model.disks.SubStatValue
import org.gimmesomepeace.zzzcompanion.core.model.disks.SubStats
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskId
import org.gimmesomepeace.zzzcompanion.core.model.ids.DiskTypeId
import org.gimmesomepeace.zzzcompanion.core.repository.DiskRepository
import java.util.UUID


class InMemoryDiskRepository: DiskRepository {
    private val disks = listOf(
        Disk.create(
            DiskId(UUID.randomUUID()),
            DiskTypeId(UUID.fromString("6f9f09fd-f7b9-467a-99c6-6f8795795b91")),
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
            Position.P1,
            MainStatSlot(
                StatType.HP,
                MainStatValue(15)
            ),
            SubStats.create(
                SubStatSlot(
                    StatType.HP_PERCENTAGE,
                    SubStatValue(0)
                ),
                SubStatSlot(
                    StatType.ATTACK_PERCENTAGE,
                    SubStatValue(2)
                ),
                SubStatSlot(
                    StatType.DEFENSE_PERCENTAGE,
                    SubStatValue(3)
                ),
                SubStatSlot(
                    StatType.DEFENSE,
                    SubStatValue(0)
                )
            )
        ),
        Disk.create(
            DiskId(UUID.randomUUID()),
            DiskTypeId(UUID.fromString("6f9f09fd-f7b9-467a-99c6-6f8795795b91")),
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
            Position.P2,
            MainStatSlot(
                StatType.ATTACK,
                MainStatValue(15)
            ),
            SubStats.create(
                SubStatSlot(
                    StatType.HP_PERCENTAGE,
                    SubStatValue(0)
                ),
                SubStatSlot(
                    StatType.ATTACK_PERCENTAGE,
                    SubStatValue(0)
                ),
                SubStatSlot(
                    StatType.DEFENSE_PERCENTAGE,
                    SubStatValue(4)
                ),
                SubStatSlot(
                    StatType.DEFENSE,
                    SubStatValue(0)
                )
            )
        )
    )

    override fun getAllByCharacterId(characterId: CharacterId): List<Disk> {
        return disks.filter { disk -> disk.characterId == characterId }
    }
}