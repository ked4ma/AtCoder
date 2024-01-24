package com.github.ked4ma.atcoder.utils.array.any.d2

inline fun <reified T> sized2DArray(row: Int, col: Int, default: T): Array<Array<T>> {
    return Array(row) { Array(col) { default } }
}

inline fun <reified T> sized2DArray(row: Int, col: Int, default: () -> T): Array<Array<T>> {
    return Array(row) { Array(col) { default.invoke() } }
}
