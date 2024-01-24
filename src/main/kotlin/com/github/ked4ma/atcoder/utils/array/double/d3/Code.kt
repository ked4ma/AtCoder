package com.github.ked4ma.atcoder.utils.array.double.d3

fun sized3DDoubleArray(row: Int, col: Int, dep: Int, default: Double): Array<Array<DoubleArray>> {
    return Array(row) { Array(col) { DoubleArray(dep) { default } } }
}

fun sized3DDoubleArray(row: Int, col: Int, dep: Int, default: () -> Double): Array<Array<DoubleArray>> {
    return Array(row) { Array(col) { DoubleArray(dep) { default.invoke() } } }
}
