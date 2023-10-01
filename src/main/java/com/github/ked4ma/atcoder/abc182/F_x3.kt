package com.github.ked4ma.atcoder.abc182

import com.github.ked4ma.atcoder.utils.input.default.*

/**
 * [ref] https://maspypy.com/atcoder-%E5%8F%82%E5%8A%A0%E6%84%9F%E6%83%B3-2020-11-08abc-182#toc3
 */
fun main() {
    val (n, x) = nextLongList().let { (nn, xx) ->
        nn.toInt() to xx
    }
    val a = nextLongList().toLongArray()
    val memo = mutableMapOf<Pair<Long, Int>, Long>()

    fun f(X: Long, i: Int): Long {
        if (X to i in memo) return memo.getValue(X to i)
        if (i == n - 1) return if (X >= 0) 1 else 0

        val b = a[i + 1]

        if (X % b == 0L) return f(X, i + 1)

        val xx = X - X % b
        val v = f(xx, i + 1) + f(xx + b, i + 1)
        memo[X to i] = v
        return v
    }

    println(f(x, 0))
}
