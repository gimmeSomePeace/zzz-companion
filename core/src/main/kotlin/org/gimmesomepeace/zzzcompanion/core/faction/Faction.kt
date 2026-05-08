package org.gimmesomepeace.zzzcompanion.core.faction

import java.net.URI


/**
 * Референсное описание фракции персонажа.
 *
 * У одного персонажа может быть лишь одна фракция.
 * В логике на уровне проекта не используется. Это лишь референсный тип.
 *
 * @property imageUrl URL картинки с изображением фракции.
 */
data class Faction (
    val id: FactionId,
    val name: String,
    val imageUrl: URI
)
