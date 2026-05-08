package org.gimmesomepeace.zzzcompanion.data.util

import java.util.UUID
import org.gimmesomepeace.zzzcompanion.core.shared.IdGenerator


class UuidIdGenerator : IdGenerator {
    override fun generateId(): String {
         return UUID.randomUUID().toString()
    }
}