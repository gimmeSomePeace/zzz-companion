package org.gimmesomepeace.zzzcompanion.core.attribute

import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize

interface AttributeRepository {
    /**
     * Возвращает страницу атрибутов, применяя фильтры и cursor-based pagination.
     *
     * @param cursor маркер, определяющий, с какого места продолжить выборку
     * Если null - возвращается первая страница.
     *
     * @param pageSize  максимальное количество атрибутов в результате.
     *
     * @param filters применяемый набор фильтров
     * Если null - фильтрация не применяется.
     */
    fun getPage(cursor: String?, pageSize: PageSize = PageSize(10), filters: AttributeFilters? = null): Page<Attribute>
}
