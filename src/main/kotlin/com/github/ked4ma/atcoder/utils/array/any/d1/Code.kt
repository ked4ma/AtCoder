package com.github.ked4ma.atcoder.utils.array.any.d1

inline fun <reified T> sizedArray(size: Int, default: T): Array<T> {
    return Array(size) { default }
}

inline fun <reified T> sizedArray(size: Int, default: (Int) -> T): Array<T> {
    return Array(size) { i -> default.invoke(i) }
}
