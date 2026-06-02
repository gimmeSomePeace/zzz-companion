package me.gimmesomepeace.zzzcompanion.filters

import me.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository

internal suspend fun <T, F> loadAllPages(
    repository: PaginationRepository<T, F>,
    pageSize: PageSize,
): List<T> {
    val result = mutableListOf<T>()
    var cursor: String? = null
    do {
        val page = repository.getPage(pageSize, cursor, null)
        result += page.items
        cursor = page.nextCursor
    } while (cursor != null)

    return result
}
