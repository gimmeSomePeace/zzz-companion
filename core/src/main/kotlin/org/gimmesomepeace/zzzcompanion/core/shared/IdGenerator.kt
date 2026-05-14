package org.gimmesomepeace.zzzcompanion.core.shared

import java.util.UUID

interface IdGenerator<T> {
    fun generate(): T

    fun <V> map(f: (T) -> V): IdGenerator<V> =
        object : IdGenerator<V> {
            override fun generate(): V = f(this@IdGenerator.generate())
        }
}

object IDGenerator {
    private object UUIDGenerator : IdGenerator<UUID> {
        override fun generate(): UUID = UUID.randomUUID()
    }

    val forUUID: IdGenerator<UUID> = UUIDGenerator
    val forString: IdGenerator<String> = UUIDGenerator.map { it.toString() }
}
