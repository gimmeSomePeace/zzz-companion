package org.gimmesomepeace.zzzcompanion.features.shared

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository

suspend fun <T, F> loadAllPages(
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
