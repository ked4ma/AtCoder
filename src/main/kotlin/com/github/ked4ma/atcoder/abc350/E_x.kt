package com.github.ked4ma.atcoder.abc350

import com.github.ked4ma.atcoder.utils.array.double.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, A, X, Y) = nextLongList()

    val xsTmp = mutableSetOf<Long>(0)
    val transMap = mutableMapOf<Long, MutableSet<Long>>()
    transMap[N] = mutableSetOf()
    var n = N
    while (n > 0) {
        xsTmp.add(n)
        transMap.getOrPut(n / A) { mutableSetOf() }.add(n)
        n /= A
    }
    var i = 0
    while (1L shl i < N) {
        i++
    }
    repeat(i) {
        val set = mutableSetOf<Long>()
        for (x in xsTmp) {
            for (b in 2..6) {
                set.add(x / b)
                transMap.getOrPut(x / b) { mutableSetOf() }.add(x)
            }
        }
        xsTmp.addAll(set)
    }
    _debug_println(xsTmp.size)
    _debug_println(transMap.size)
    val xs = xsTmp.toList().sorted()

    val dp = sizedDoubleArray(xs.size, Double.MAX_VALUE / 2)
    dp[0] = 0.0
    for (i in 1 until xs.size) {
        val n = xs[i]
        // x
        val xi = xs.binarySearch(n / A)
        val x = X + dp[xi]
        // y
        var y = 6.0 * Y / 5
        for (b in 2..6) {
            val yi = xs.binarySearch(n / b)
            y += dp[yi] / 5
        }
        dp[i] = min(x, y)
    }
    println("%.7f".format(dp.last()))
}
