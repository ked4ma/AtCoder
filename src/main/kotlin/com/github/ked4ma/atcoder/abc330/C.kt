package com.github.ked4ma.atcoder.abc330

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val D = nextLong()
    var ans = Long.MAX_VALUE
    (0..ceil(sqrt(D.toDouble())).toLong()).forEach { x ->
        val res = D - x * x
        if (res < 0) {
            ans = min(ans, abs(res))
            return@forEach
        }
        val y = sqrt(res.toDouble()).toLong()
        ans = min(ans, abs(res - y * y))
        ans = min(ans, abs(res - (y + 1).let { it * it }))
    }
    println(ans)
}