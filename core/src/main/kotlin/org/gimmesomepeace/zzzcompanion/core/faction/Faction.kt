package org.gimmesomepeace.zzzcompanion.core.faction

import java.net.URI


/**
 * Фракция
 *
 *
 * @property imageUri URI изображения эмблемы фракции.
 */
@ConsistentCopyVisibility
data class Faction private constructor(
    val id: FactionId,
    val name: String,
    val imageUri: URI
) {
    companion object {
        fun create(
            id: FactionId,
            name: String,
            imageUri: URI
        ): Faction {
            val trimmedName = name.trim()

            require(trimmedName.isNotBlank()) { "Name must not be blank" }
            return Faction(id, trimmedName, imageUri)
        }
    }
}
