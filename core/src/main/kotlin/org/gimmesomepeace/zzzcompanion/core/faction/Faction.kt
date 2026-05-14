package org.gimmesomepeace.zzzcompanion.core.faction

import java.net.URI


/**
 * Референсное описание фракции персонажа.
 *
 * У одного персонажа может быть лишь одна фракция.
 * В логике на уровне проекта не используется. Это лишь референсный тип.
 *
 * @property imageUri URL картинки с изображением фракции.
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
            require(name.isNotBlank()) { "Name must not be blank" }
            return Faction(id, name, imageUri)
        }
    }
}
