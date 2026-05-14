package org.gimmesomepeace.zzzcompanion.core.faction

import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize


interface FactionRepository {
    /**
     * Возвращает страницу фракций, применяя фильтры и cursor-based pagination.
     *
     * @param cursor маркер, определяющий, с какого места продолжить выборку
     * Если null - возвращается первая страница.
     *
     * @param pageSize  максимальное количество фракций в результате.
     *
     * @param filters применяемый набор фильтров
     * Если null - фильтрация не применяется.
     */
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: FactionFilters? = null,
    ) : Page<Faction>
}
