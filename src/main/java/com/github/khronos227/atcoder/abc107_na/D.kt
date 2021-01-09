package com.github.khronos227.atcoder.abc107_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextInt()
    val data = nextIntList().toTypedArray()
    val sorted = data.sorted()
    _debug_println(sorted.joinToString(", "))

    var l = 0
    var r = N
    val n = N.toLong() * (N + 1) / 2
    while (r - l > 1) {
        val m = (r + l) / 2
        val x = sorted[m]
        val s = sizedArray(N + 1, 0)
        repeat(N) {
            s[it + 1] = s[it] + if (data[it] >= x) 1 else -1
        }
        _debug_println(s.joinToString(", "))
        val bit = FenwickTree(2 * N + 1)
        var sum = 0L
        repeat(N + 1) {
            // calc inversion number.
            // target: S_i <= S_j
            // +1 means "=" of above fomula
            sum += bit.sum(0, s[it] + N + 1)
            bit.add(s[it] + N, 1) // count appeared number (S)
        }
        _debug_println("$sum $m $x ${n / 2}")
        if (sum >= n / 2) {
            l = m
        } else {
            r = m
        }
    }
    println(sorted[l])
}
