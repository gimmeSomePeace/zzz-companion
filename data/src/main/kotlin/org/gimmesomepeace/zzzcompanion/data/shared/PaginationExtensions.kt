package org.gimmesomepeace.zzzcompanion.data.shared

import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize

fun <T> Iterable<T>.paginate(cursor: String?, pageSize: PageSize, idSelector: (T) -> String): Page<T> {
    val itemsWithExtra = this
        .filter { cursor == null || idSelector(it) > cursor }
        .take(pageSize.value + 1)
    val hasMore = itemsWithExtra.size > pageSize.value
    val result = itemsWithExtra.take(pageSize.value)

    val nextCursor = if (hasMore) idSelector(result.last()) else null

    return Page(result, nextCursor)
}
