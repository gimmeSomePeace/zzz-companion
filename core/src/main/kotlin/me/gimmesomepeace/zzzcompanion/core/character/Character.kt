package me.gimmesomepeace.zzzcompanion.core.character

import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.faction.FactionId
import me.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import me.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
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
 * @property id Уникальный идентификатор
 * @property name Имя
 * @property factionId Идентификатор фракции
 * @property attributeId Идентификатор атрибута
 * @property specialityId Идентификатор специализации
 * @property rarity Уровень редкости
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
                imageUri = imageUri,
            )
        }
    }
}
