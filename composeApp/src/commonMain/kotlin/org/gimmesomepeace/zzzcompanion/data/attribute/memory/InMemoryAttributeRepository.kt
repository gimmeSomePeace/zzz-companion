package org.gimmesomepeace.zzzcompanion.data.attribute.memory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.gimmesomepeace.zzzcompanion.core.model.Attribute
import org.gimmesomepeace.zzzcompanion.core.model.id.AttributeId
import org.gimmesomepeace.zzzcompanion.core.repository.AttributeRepository
import java.net.URI
import java.util.UUID

class InMemoryAttributeRepository : AttributeRepository {
    private val attributes = MutableStateFlow(
        listOf(
            Attribute(
                AttributeId(UUID.fromString("bd4779b3-36df-4280-81a8-59d77b8940ec")),
                "Physical",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902")
            ),
            Attribute(
                AttributeId(UUID.fromString("59c71ade-975d-4cfd-b782-96560a5d6620")),
                "Ice",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955")
            )
        )
    )

    override fun getAll(): Flow<List<Attribute>> = attributes
}