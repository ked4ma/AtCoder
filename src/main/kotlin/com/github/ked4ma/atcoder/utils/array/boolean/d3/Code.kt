package com.github.ked4ma.atcoder.utils.array.boolean.d3

fun sized3DBooleanArray(row: Int, col: Int, dep: Int, default: Boolean): Array<Array<BooleanArray>> {
    return Array(row) { Array(col) { BooleanArray(dep) { default } } }
}

fun sized3DBooleanArray(row: Int, col: Int, dep: Int, default: () -> Boolean): Array<Array<BooleanArray>> {
    return Array(row) { Array(col) { BooleanArray(dep) { default.invoke() } } }
}
