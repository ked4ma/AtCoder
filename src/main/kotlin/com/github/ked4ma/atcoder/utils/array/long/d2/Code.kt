package com.github.ked4ma.atcoder.utils.array.long.d2

fun sized2DLongArray(row: Int, col: Int, default: Long): Array<LongArray> {
    return Array(row) { LongArray(col) { default } }
}

fun sized2DLongArray(row: Int, col: Int, default: (i: Int, j: Int) -> Long): Array<LongArray> {
    return Array(row) { i -> LongArray(col) { j -> default.invoke(i, j) } }
}
