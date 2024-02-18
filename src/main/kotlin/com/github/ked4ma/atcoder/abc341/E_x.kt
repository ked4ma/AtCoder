package com.github.ked4ma.atcoder.abc341

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val S = next()
    val segTree = SegmentTree(
        n = N + 1,
        fx = {x1, x2 -> x1 + x2},
        fm = {x1, _ -> 1 - x1},
        0
    )
    for (i in 0 until N - 1) {
        if (S[i] != S[i + 1]) segTree.set(i + 1, 1)
    }
    segTree.build()
    repeat(Q) {
        val (q, L, R) = nextIntList()
        when (q) {
            1 -> {
                segTree.update(L - 1, 0)
                segTree.update(R, 0)
            }

            2 -> {
                val a = try {
                    segTree.query(L, R)
                } catch (_: Exception) {
                    0
                }
                println(if (a == (R - L).toLong()) "Yes" else "No")
            }
        }
    }

}