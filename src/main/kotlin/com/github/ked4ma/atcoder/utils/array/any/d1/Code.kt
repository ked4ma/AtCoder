package com.github.ked4ma.atcoder.utils.array.any.d1

inline fun <reified T> sizedArray(size: Int, default: T): Array<T> {
    return Array(size) { default }
}

inline fun <reified T> sizedArray(size: Int, default: () -> T): Array<T> {
    return Array(size) { default.invoke() }
}
