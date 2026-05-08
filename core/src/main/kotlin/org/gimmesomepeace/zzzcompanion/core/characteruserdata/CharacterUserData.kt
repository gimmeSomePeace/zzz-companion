package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId


/**
 * Наличие сущности с конкретным id персонажа отражает наличие этого персонажа у пользователя.
 * NB: после последний изменений эта модель практически опустела,
 * но при этом не уверен, что объединение этой модели с моделью Character это хорошая идея.
 */
data class CharacterUserData(
    val id: CharacterId,
    val equippedDisks: EquippedDisks
)
