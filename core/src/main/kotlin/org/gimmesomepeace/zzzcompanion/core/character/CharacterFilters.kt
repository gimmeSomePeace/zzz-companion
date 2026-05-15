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
data class CharacterFilters(
    val query: String = "",
    val factionId: FactionId? = null,
    val attributeId: AttributeId? = null,
    val specialityId: SpecialityId? = null,
    val rarity: Rarity? = null,
)
