package org.gimmesomepeace.zzzcompanion.data.util

import java.util.UUID
import org.gimmesomepeace.zzzcompanion.core.util.IdGenerator


class UuidIdGenerator : IdGenerator {
    override fun generateId(): String {
         return UUID.randomUUID().toString()
    }
}