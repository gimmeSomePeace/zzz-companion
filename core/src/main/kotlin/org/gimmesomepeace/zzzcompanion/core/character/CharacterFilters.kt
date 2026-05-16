package org.gimmesomepeace.zzzcompanion.core.character

import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId

/**
 * Набор параметров, по которым выполняется фильтрация персонажей.
 *
 * Пустые значения (null или пустая строка) означают, что соответствующий фильтр не применяется.
 * @property query строка, используемая при фильтрации по имени персонажа.
 * @property factionId Идентификатор фракции
 * @property attributeId Идентификатор атрибута
 * @property specialityId Идентификатор специализации
 * @property rarity Уровень редкости
 */
@ConsistentCopyVisibility
data class CharacterFilters private constructor(
    val query: String? = null,
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarity: Rarity? = null,
) {
    fun withQuery(query: String?): CharacterFilters {
        return copy(query = normalizeQuery(query))
    }

    fun withFactionId(factionId: FactionId?): CharacterFilters {
        return copy(factionId = factionId)
    }

    fun withAttributeId(attributeId: AttributeId?): CharacterFilters {
        return copy(attributeId = attributeId)
    }

    fun withSpecialityId(specialityId: SpecialityId?): CharacterFilters {
        return copy(specialityId = specialityId)
    }

    fun withRarity(rarity: Rarity?): CharacterFilters {
        return copy(rarity = rarity)
    }

    companion object {
        fun create(
            query: String? = null,
            factionId: FactionId? = null,
            attributeId: AttributeId? = null,
            specialityId: SpecialityId? = null,
            rarity: Rarity? = null,
        ): CharacterFilters {
            return CharacterFilters(
                normalizeQuery(query),
                factionId,
                attributeId,
                specialityId,
                rarity
            )
        }

        private fun normalizeQuery(query: String?): String? {
            return query?.trim()
        }
    }
}
