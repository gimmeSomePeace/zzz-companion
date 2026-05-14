package org.gimmesomepeace.zzzcompanion.core.rarity

import java.net.URI


/**
 * Уровень редкости
 *
 *
 * @property imageUri URI изображения уровня редкости.
 */
enum class Rarity(
    val title: String,
    val imageUri: URI,
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
