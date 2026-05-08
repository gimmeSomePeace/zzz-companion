package org.gimmesomepeace.zzzcompanion.data.shared

import org.gimmesomepeace.zzzcompanion.core.shared.IdGenerator
import java.util.UUID

class UuidIdGenerator : IdGenerator {
    override fun generateId(): String {
         return UUID.randomUUID().toString()
    }
}