package com.github.ked4ma.atcoder.abc354

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (A, B, C, D) = nextLongList()
    if (A < 0) {
        val a = if (A % 4 == 0L) abs(A) else (abs(A) / 4 + 1) * 4
        A += a
        C += a
    }
    if (B < 0) {
        val b = if (B % 2 == 0L) abs(B) else (abs(B) / 2 + 1) * 4
        B += b
        D += b
    }
    _debug_println("$A $B $C $D")

    fun calc(x: Long, y: Long): Long {
        var x1 = 4 * (x / 4)
        x1 += when (x % 4) {
            3L -> 3
            2L -> 3
            1L -> 2
            else -> 0
        }
        var x2 = 4 * (x / 4)
        x2 += when (x % 4) {
            3L -> 4
            2L -> 3
            1L -> 1
            else -> 0
        }
        var res = (x1 + x2) * (y / 2)
        if (y % 2 == 1L) {
            res += x1
        }
        _debug_println("$x $y : ($x1 $x2) -> $res")
        return res
    }

    println(calc(C, D) - calc(A, D) - calc(C, B) + calc(A, B))
}
