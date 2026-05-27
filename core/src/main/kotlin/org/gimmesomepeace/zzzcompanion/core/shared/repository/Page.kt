package org.gimmesomepeace.zzzcompanion.core.shared.repository

/**
 * Страница данных при курсорной пагинации.
 *
 * @property items Элементы текущей страницы.
 * @property nextCursor Курсор для загрузки следующей страницы
 */
data class Page<T>(
    val items: List<T>,
    val nextCursor: String?,
)
