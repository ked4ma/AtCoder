package com.github.ked4ma.atcoder.abc374

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    data class Machine(val a: Long, val p: Long, val b: Long, val q: Long)
    val (N, X) = nextIntList()
    val machines = times(N) {
        val (A, P, B, Q) = nextLongList()
        Machine(A, P, B, Q)
    }

    var ok = 0L
    var ng = Int.MAX_VALUE.toLong()
    while (ok + 1 < ng) {
        val w = (ok + ng) / 2
        var cost = 0L
        for ((a, p, b, q) in machines) {
            var c = Long.MAX_VALUE
            for (i in 0..b) {
                c = min(c, p * i + ((w - a * i).coerceAtLeast(0) + b - 1) / b * q)
            }
            for (j in 0..a) {
                c = min(c, q * j + ((w - b * j).coerceAtLeast(0) + a - 1) / a * p)
            }
            cost += c
        }
        _debug_println("$w $cost ${cost <= X}")
        if (cost <= X) {
            ok = w
        } else {
            ng = w
        }
    }
    println(ok)
}
