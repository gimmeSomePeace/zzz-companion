package org.gimmesomepeace.zzzcompanion.core.speciality

import org.gimmesomepeace.zzzcompanion.core.shared.Page
import org.gimmesomepeace.zzzcompanion.core.shared.PageSize

interface SpecialityRepository {
    /**
     * Возвращает страницу специализаций, применяя фильтры и cursor-based pagination.
     *
     * @param cursor маркер, определяющий, с какого места продолжить выборку
     * Если null - возвращается первая страница.
     *
     * @param pageSize  максимальное количество специализаций в результате.
     *
     * @param filters применяемый набор фильтров
     * Если null - фильтрация не применяется.
     */
    fun getPage(
        cursor: String?,
        pageSize: PageSize = PageSize(10),
        filters: SpecialityFilters? = null,
    ): Page<Speciality>
}
