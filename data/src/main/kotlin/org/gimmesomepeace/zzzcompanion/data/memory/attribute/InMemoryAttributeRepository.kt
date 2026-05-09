package org.gimmesomepeace.zzzcompanion.data.memory.attribute

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeFilters
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeRepository
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.net.URI
import java.util.UUID

class InMemoryAttributeRepository : AttributeRepository {
    private val attributes = listOf(
        Attribute.create(
            AttributeId(UUID.fromString("bd4779b3-36df-4280-81a8-59d77b8940ec")),
            "Physical",
            URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902")
        ),
        Attribute.create(
            AttributeId(UUID.fromString("59c71ade-975d-4cfd-b782-96560a5d6620")),
            "Ice",
            URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955")
        )
    )

    override fun getPage(
        cursor: String?,
        pageSize: PageSize,
        filters: AttributeFilters?
    ): Page<Attribute> {
        val filteredItems = if (filters != null) attributes.applyFilters(filters) else attributes

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSize
        ) { attribute ->
            attribute.id.value.toString()
        }
    }
}