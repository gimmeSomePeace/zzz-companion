package org.gimmesomepeace.zzzcompanion.core.characteruserdata

import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize

enum class AddCharacterUserDataResult {
    ADDED,
    ALREADY_EXISTS,
}

interface CharacterUserDataRepository {
    /**
     * Возвращает страницу данных о персонажах, применяя cursor-based pagination.
     *
     * @param cursor маркер, определяющий, с какого места продолжить выборку
     * Если null - возвращается первая страница.
     *
     * @param pageSize  максимальное количество атрибутов в результате.
     */
    fun getByPage(cursor: String?, pageSize: PageSize): Page<CharacterUserData>

    fun getById(id: CharacterId): CharacterUserData?

    /**
     * Возвращает данные пользователя о персонажах по указанным идентификаторам.
     * Персонажи, отсутствующие у пользователя, не включаются в результат.
     */
    fun batchGet(ids: List<CharacterId>): Map<CharacterId, CharacterUserData>
    fun addIfNotExists(characterUserData: CharacterUserData): AddCharacterUserDataResult
}
