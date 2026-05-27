package org.gimmesomepeace.zzzcompanion.core.shared.repository

/**
 * Интерфейс репозитория для постраничного получения сущностей с поддержкой фильтрации.
 *
 * @param T Тип сущности.
 * @param F Тип набора фильтров.
 */
interface PaginationRepository<T, F> {
    /**
     * Возвращает страницу сущностей, применяя фильтры и cursor-based pagination.
     *
     * @param cursor маркер, определяющий, с какого места продолжить выборку
     * Каждая реализация должна гарантировать, что при null возвращается первая страница.
     *
     * @param pageSize  максимальное количество элементов в результате.
     *
     * @param filters применяемый набор фильтров
     * При null подразумевается, что фильтрация не применяется.
     */
    suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: F?
    ): Page<T>
}
