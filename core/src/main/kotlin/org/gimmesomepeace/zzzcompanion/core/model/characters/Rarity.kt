package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.RarityId
import java.net.URI


/**
 * Референсное описание уровня редкости персонажа.
 *
 * В логике на уровне проекта не используется. Это лишь референсный тип.
 * NB: Уровни редкостей персонажа маловероятно будут обновляться,
 * поэтому в целом можно и сделать как enum в будущем.
 * К другим похожим сущностям вроде Faction это не относится, т.к. они обновляются довольно часто
 *
 * @property imageUrl URL картинки с изображением уровня редкости.
 */
data class Rarity(
    val id: RarityId,
    val name: String,
    val imageUrl: URI
)
