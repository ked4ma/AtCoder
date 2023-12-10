package com.github.ked4ma.atcoder.abc332

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList()
    val S = next().toCharArray()
    var rack = 0L
    var a = M
    var b = 0L
    S.forEach {
        when (it) {
            '0' -> {
                rack = max(rack, abs(min(a, 0L) + min(b, 0L)))
                a = M
                b = 0L
            }

            '1' -> {
                a--
            }

            else -> {
                b--
            }
        }
    }
    rack = max(rack, abs(min(a, 0L) + min(b, 0L)))
    println(rack)
}