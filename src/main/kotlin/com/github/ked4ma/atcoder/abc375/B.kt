package com.github.ked4ma.atcoder.abc375

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.pow
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val XY = listOf(0L to 0L) + times(N) {
        val (X, Y) = nextLongList()
        X to Y
    } + listOf(0L to 0L)
    var ans = 0.0
    for (i in range(N + 1)) {
        val (a, b) = XY[i]
        val (c, d) = XY[i + 1]
        ans += sqrt((a - c).toDouble().pow(2) + (b - d).toDouble().pow(2))
    }
    println(ans)
}
