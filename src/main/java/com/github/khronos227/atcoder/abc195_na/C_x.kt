package com.github.khronos227.atcoder.abc195_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextLong()
    _debug_println(N)

    var sum = 0L

    if (N >= 1_000L) sum += N - 999L
    if (N >= 1_000_000L) sum += N - 999_999L
    if (N >= 1_000_000_000L) sum += N - 999_999_999L
    if (N >= 1_000_000_000_000L) sum += N - 999_999_999_999L

    println(sum)
}
