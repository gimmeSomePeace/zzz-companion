package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.SpecialityId
import java.net.URI

/**
 * Референсное описание специализации персонажа.
 *
 * У одного персонажа может быть лишь одна специализация (Устрашение, аномалия и т.д.)
 * В логике на уровне проекта не используется. Это лишь референсный тип.
 *
 * @property imageUrl URL картинки с изображением специализации.
 */
data class Speciality(
    val id: SpecialityId,
    val name: String,
    val imageUrl: URI
)
