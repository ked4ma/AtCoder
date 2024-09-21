package com.github.ked4ma.atcoder.utils.array.int.d1

fun sizedIntArray(row: Int, default: Int): IntArray {
    return IntArray(row) { default }
}

fun sizedIntArray(row: Int, default: (Int) -> Int): IntArray {
    return IntArray(row) { i -> default.invoke(i) }
}
