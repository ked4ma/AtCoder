package com.github.ked4ma.atcoder.abc353

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.cumlative.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 100_000_000L
    val N = nextInt()
    val A = nextLongList().sorted()
    val cumA = A.cumulativeSum()

    fun bs(a: Long, sl: Int): Int {
        var l = sl
        var r = N
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (a + A[m] >= MOD) {
                r = m
            } else {
                l = m
            }
        }
        _debug_println(r)
        return r
    }

    var ans = 0L
    for (i in range(N - 1)) {
        val ov = bs(A[i], i)
        ans += (N - 1 - i) * A[i] + cumA[N] - cumA[i + 1] - MOD * (N - ov)
    }
    println(ans)
}
