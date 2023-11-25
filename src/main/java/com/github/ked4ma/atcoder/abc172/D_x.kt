package com.github.ked4ma.atcoder.abc172

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val n = nextInt()

    var ans = 0L
    (1..n).forEach { x ->
        val y = n / x
        ans += y.toLong().times(y.plus(1)).times(x).div(2)
    }
    println(ans)
}
