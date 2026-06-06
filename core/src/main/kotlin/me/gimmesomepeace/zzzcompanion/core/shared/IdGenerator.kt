package me.gimmesomepeace.zzzcompanion.core.shared

import java.util.UUID

/**
 * Генератор идентификаторов.
 *
 * @param T Тип идентификатора.
 */
interface IdGenerator<T> {
    /**
     * Генерирует новый уникальный идентификатор.
     *
     * @return Сгенерированный идентификатор.
     */
    fun generate(): T

    /**
     * Преобразует генератор идентификаторов в генератор другого типа.
     * Идея следующая: генератор так же генерирует идентификаторы типа [T],
     * Но при помощи функции [f] полученный идентификатор преобразуется в идентификатор типа [V].
     * Стоит учесть, что функция [f] должна быть инъективной, иначе невозможно гарантировать
     * уникальность идентификаторов, сгенерированных новым генератором.
     *
     * @param V Тип нового идентификатора.
     * @param f функция преобразования идентификаторов типа [T] в тип [V].
     *
     * @return Новый генератор идентификаторов типа [V].
     */
    fun <V> map(f: (T) -> V): IdGenerator<V> =
        object : IdGenerator<V> {
            override fun generate(): V = f(this@IdGenerator.generate())
        }
}

/**
 * Глобальная фабрика стандартных генераторов идентификаторов.
 *
 * Предоставляет реализации для распространенных типов.
 */
object IDGenerator {
    private object UUIDGenerator : IdGenerator<UUID> {
        override fun generate(): UUID = UUID.randomUUID()
    }

    /**
     * Генератор UUID V4.
     */
    val forUUID: IdGenerator<UUID> = UUIDGenerator

    /**
     * Генератор строковых идентификаторов на основе UUID V4.
     *
     * Представляет UUID в виде строки.
     */
    val forString: IdGenerator<String> = UUIDGenerator.map { it.toString() }
}
