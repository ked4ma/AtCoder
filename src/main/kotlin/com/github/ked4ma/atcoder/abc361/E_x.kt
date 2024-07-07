package com.github.ked4ma.atcoder.abc361

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()

    var allCost = 0L
    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    repeat(N - 1) {
        val (A, B, C) = nextIntList()
        G[A - 1].add(B - 1 to C.toLong())
        G[B - 1].add(A - 1 to C.toLong())
        allCost += C
    }

    fun farthest(u: Int, p: Int = -1, cost: Long = 0): Pair<Int, Long> {
        var res = u to cost
        for ((v, c) in G[u]) {
            if (v == p) continue
            val w = farthest(v, u, cost + c)
            if (w.second > res.second) {
                res = w
            }
        }
        return res
    }

    val start = farthest(0).first
    val (end, D) = farthest(start)

    println(2 * allCost - D)
}
