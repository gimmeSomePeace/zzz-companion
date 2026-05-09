package org.gimmesomepeace.zzzcompanion.core.rarity

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
enum class Rarity(
    val title: String,
    val imageUrl: URI,
) {
    S(
        "S",
        URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/d/d0/Icon_AgentRank_S.png/revision/latest/scale-to-width-down/32?cb=20240914140011")
    ),
    A(
        "A",
        URI("https://static.wikia.nocookie.net/zenless-zone-zero/images/5/5c/Icon_AgentRank_A.png/revision/latest/scale-to-width-down/32?cb=20240914135957")
    ),
}
