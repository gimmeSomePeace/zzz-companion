package org.gimmesomepeace.zzzcompanion.core.character

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import java.net.URI

/**
 * Игровой персонаж.
 *
 * Каждый персонаж имеет:
 *  - Фракцию
 *  - Атрибут
 *  - Специализацию
 *  - Уровень редкости
 *
 *  Инварианты:
 *   - Имя персонажа не должно быть пустым
 *
 * @property imageUri URI изображения персонажа
 */
@ConsistentCopyVisibility
data class Character private constructor(
    val id: CharacterId,
    val name: String,

    val factionId: FactionId,
    val attributeId: AttributeId,
    val specialityId: SpecialityId,
    val rarity: Rarity,

    val imageUri: URI,
) {
    companion object {
        fun create(
            id: CharacterId,
            name: String,
            factionId: FactionId,
            attributeId: AttributeId,
            specialityId: SpecialityId,
            rarity: Rarity,
            imageUri: URI,
        ): Character {
            val trimmedName = name.trim()

            require(trimmedName.isNotBlank()) { "Name must not be blank" }
            return Character(
                id = id,
                name = trimmedName,
                factionId = factionId,
                attributeId = attributeId,
                specialityId = specialityId,
                rarity = rarity,
                imageUri = imageUri
            )
        }
    }
}
