package com.github.ked4ma.atcoder.utils.array.long.d3

fun sized3DLongArray(row: Int, col: Int, dep: Int, default: Long): Array<Array<LongArray>> {
    return Array(row) { Array(col) { LongArray(dep) { default } } }
}

fun sized3DLongArray(row: Int, col: Int, dep: Int, default: () -> Long): Array<Array<LongArray>> {
    return Array(row) { Array(col) { LongArray(dep) { default.invoke() } } }
}
