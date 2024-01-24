package com.github.ked4ma.atcoder.utils.list.d1

inline fun <reified T> sizedListOf(n: Int, default: T): List<T> {
    return List(n) { default }
}

inline fun <reified T> sizedListOf(n: Int, default: (Long) -> T): List<T> {
    return List(n) { index -> default(index.toLong()) }
}
