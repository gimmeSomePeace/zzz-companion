package org.gimmesomepeace.uikit

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

fun ColorFilter.Companion.grayscale(): ColorFilter {
    /**
     * Создаёт grayscale (чёрно-белый) ColorFilter через ColorMatrix.
     *
     *  Как это работает:
     *  ColorMatrix — это матрица преобразования цвета, которая применяется к каждому пикселю.
     *  Каждый новый канал (R', G', B', A') считается как линейная комбинация исходных:
     *
     *  R' = aR + bG + cB + dA + e
     *  G' = aR + bG + cB + dA + e
     *  B' = aR + bG + cB + dA + e
     *  A' = A
     *
     *  В этой матрице:
     *
     *  0.299 0.587 0.114 0 0
     *  0.299 0.587 0.114 0 0
     *  0.299 0.587 0.114 0 0
     *  0     0     0     1 0
     *
     *  происходит следующее:
     *
     *  1. Все три цветовых канала (R, G, B) заменяются одним и тем же значением:
     *      gray = 0.299 * R + 0.587 * G + 0.114 * B
     *
     *  2. В результате:
     *      R = G = B = gray → изображение становится в оттенках серого
     *
     *  * 3. Коэффициенты 0.299, 0.587, 0.114 — это не случайные числа.
     *      Они отражают восприятие яркости человеческим глазом:
     *        - зелёный вносит наибольший вклад
     *        - красный меньше
     *        - синий ещё меньше
     *
     *  Источник: https://en.wikipedia.org/wiki/Grayscale
     */
    val matrix = ColorMatrix(
        floatArrayOf(
            0.299f, 0.587f, 0.114f, 0f, 0f,
            0.299f, 0.587f, 0.114f, 0f, 0f,
            0.299f, 0.587f, 0.114f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f
        )
    )
    return ColorFilter.colorMatrix(matrix)
}
