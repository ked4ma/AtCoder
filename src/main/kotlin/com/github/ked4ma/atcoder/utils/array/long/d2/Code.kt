package com.github.ked4ma.atcoder.utils.array.long.d2

fun sized2DLongArray(row: Int, col: Int, default: Long): Array<LongArray> {
    return Array(row) { LongArray(col) { default } }
}

fun sized2DLongArray(row: Int, col: Int, default: () -> Long): Array<LongArray> {
    return Array(row) { LongArray(col) { default.invoke() } }
}
