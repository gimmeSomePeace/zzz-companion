package org.gimmesomepeace.zzzcompanion.data.storage.local.attribute

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URI


class FakeAttributeLocalDataSource : AttributeLocalDataSource {
    private val attributes = MutableStateFlow(
        listOf(
            AttributeLocalEntity(
                "1",
                "Physical",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/c/ce/Icon_Physical.png/revision/latest/scale-to-width-down/32?cb=20251231181902")
            ),
            AttributeLocalEntity(
                "2",
                "Ice",
                URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/5/52/Icon_Ice.png/revision/latest/scale-to-width-down/32?cb=20251231181955")
            )
        )
    )

    override fun getAll(): Flow<List<AttributeLocalEntity>> {
        return attributes.asStateFlow()
    }
}