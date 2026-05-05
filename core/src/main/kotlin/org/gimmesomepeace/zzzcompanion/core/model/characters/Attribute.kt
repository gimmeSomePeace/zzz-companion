package org.gimmesomepeace.zzzcompanion.core.model.characters

import org.gimmesomepeace.zzzcompanion.core.model.ids.AttributeId
import java.net.URI


/**
 * Референсное описание атрибута персонажа.
 *
 * У одного персонажа может быть лишь один атрибут (Лед, электричество и тд)
 * Атрибут используется в расчетах игровых механик и влияет на поведение персонажа.
 * В логике на уровне проекта не используется. Это лишь референсный тип.
 *
 * @property imageUrl URL картинки с изображением атрибута.
 */
data class Attribute(
    val id: AttributeId,
    val name: String,
    val imageUrl: URI
)
