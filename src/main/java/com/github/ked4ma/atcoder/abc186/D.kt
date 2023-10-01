package com.github.ked4ma.atcoder.abc186

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = nextInt()
    val a = nextLongList().sorted()
    var sub = 0L
    var ans = 0L
    for (i in 0 until a.lastIndex) {
        sub += a[i]
        ans += a[i + 1] * (i + 1) - sub
    }
    println(ans)
}
