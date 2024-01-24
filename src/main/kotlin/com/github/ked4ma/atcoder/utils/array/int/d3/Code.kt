package com.github.ked4ma.atcoder.utils.array.int.d3

fun sized3DIntArray(row: Int, col: Int, dep: Int, default: Int): Array<Array<IntArray>> {
    return Array(row) { Array(col) { IntArray(dep) { default } } }
}

fun sized3DIntArray(row: Int, col: Int, dep: Int, default: () -> Int): Array<Array<IntArray>> {
    return Array(row) { Array(col) { IntArray(dep) { default.invoke() } } }
}
