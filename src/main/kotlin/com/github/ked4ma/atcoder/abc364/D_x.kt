package com.github.ked4ma.atcoder.abc364

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.int.bound.lowerBound
import com.github.ked4ma.atcoder.utils.list.int.bound.upperBound

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList().sorted()

    fun f(b: Int, x: Int): Int {
        val lb = A.lowerBound(b - x)
        val ub = A.upperBound(b + x)
        // _debug_println("$x: $lb $ub")
        return ub - lb
    }
    repeat(Q) {
        val (b, k) = nextIntList()
        var ng = -1
        var ok = Int.MAX_VALUE / 2
        while (ng + 1 < ok) {
            val m = (ok + ng) / 2
            if (f(b, m) >= k) {
                ok = m
            } else {
                ng = m
            }
        }
        println(ok)
    }
}
