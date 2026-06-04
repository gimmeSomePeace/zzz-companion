package me.gimmesomepeace.zzzcompanion.core.characteruserdata

import me.gimmesomepeace.zzzcompanion.core.character.CharacterId

/**
 * Данные о персонаже пользователя.
 *
 * Наличие записи означает, что пользователь владеет персонажем.
 *
 * @property id Идентификатор персонажа, к которому относятся данные.
 * @property equippedDisks Расположение дисков по слотам персонажа.
 */
@ConsistentCopyVisibility
data class CharacterUserData private constructor(
    val id: CharacterId,
    val equippedDisks: EquippedDisks,
) {
    companion object {
        fun create(
            id: CharacterId,
            equippedDisks: EquippedDisks,
        ): CharacterUserData = CharacterUserData(id, equippedDisks)
    }
}
