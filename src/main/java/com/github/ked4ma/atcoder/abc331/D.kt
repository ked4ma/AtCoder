package com.github.ked4ma.atcoder.abc331

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.cumlative.d2sum.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextLongList()
    val P = times(N) {
        next().map { if (it == 'B') 1L else 0L }.toTypedArray()
    }.toTypedArray()
    val cum = CumulativeSum2D(P as Array<Array<out Number>>)
    _debug_println(cum.data)
    loop(Q) {
        var ans = 0L
        val (A, B, C, D) = nextLongList() // y x y x
        val a = A / N
        val b = B / N
        val c = C / N
        val d = D / N
        if (a == c && b == d) {
            ans = cum.getSumOf((B % N).toInt(), (A % N).toInt(), (D % N).toInt(), (C % N).toInt())
        } else if (a == c) { // landscape
            ans += cum.getSumOf(0, (A % N).toInt(), N.toInt() - 1, (C % N).toInt()) * (d - b - 1)
            // left
            ans += cum.getSumOf((B % N).toInt(), (A % N).toInt(), N.toInt() - 1, (C % N).toInt())
            // right
            ans += cum.getSumOf(0, (A % N).toInt(), (D % N).toInt(), (C % N).toInt())
        } else if (b == d) { // portrait
            ans += cum.getSumOf((B % N).toInt(), 0, (D % N).toInt(), N.toInt() - 1) * (c - a - 1)
            // top
            ans += cum.getSumOf((B % N).toInt(), (A % N).toInt(), (D % N).toInt(), N.toInt() - 1)
            // bottom
            ans += cum.getSumOf((B % N).toInt(), 0, (D % N).toInt(), (C % N).toInt())
        } else {
            _debug_println("$a $b $c $d")
            ans += cum.getSumOf(0, 0, N.toInt() - 1, N.toInt() - 1) * (d - b - 1) * (c - a - 1)
            // top-left
            ans += cum.getSumOf((B % N).toInt(), (A % N).toInt(), N.toInt() - 1, N.toInt() - 1)
            // top-right
            ans += cum.getSumOf(0, (A % N).toInt(), (D % N).toInt(), N.toInt() - 1)
            // bottom-left
            ans += cum.getSumOf((B % N).toInt(), 0, N.toInt() - 1, (C % N).toInt())
            // bottom-right
            ans += cum.getSumOf(0, 0, (D % N).toInt(), (C % N).toInt())
            // top
            ans += cum.getSumOf(0, (A % N).toInt(), N.toInt() - 1, N.toInt() - 1) * (d - b - 1)
            // left
            ans += cum.getSumOf((B % N).toInt(), 0, N.toInt() - 1, N.toInt() - 1) * (c - a - 1)
            // right
            ans += cum.getSumOf(0, 0, (D % N).toInt(), N.toInt() - 1) * (c - a - 1)
            // bottom
            ans += cum.getSumOf(0, 0, N.toInt() - 1, (C % N).toInt()) * (d - b - 1)
        }

        println(ans)
    }
}