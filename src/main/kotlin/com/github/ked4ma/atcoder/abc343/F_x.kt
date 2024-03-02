package com.github.ked4ma.atcoder.abc343

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.general.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]

private data class Data(val first: Int, val second: Int, val fCount: Int, val sCount: Int)

fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList()

    val fx: (Data, Data) -> Data = { x1, x2 ->
        var f = x1.first
        var fC = x1.fCount
        var s = x1.second
        var sC = x1.sCount
        if (f == x2.first) {
            fC += x2.fCount
        } else if (f < x2.first) {
            s = f
            sC = fC
            f = x2.first
            fC = x2.fCount
        } else if (s == x2.first) {
            sC += x2.fCount
        } else if (s < x2.first) {
            s = x2.first
            sC = x2.fCount
        }
        if (s == x2.second) {
            sC += x2.sCount
        } else if (s < x2.second) {
            s = x2.second
            sC = x2.sCount
        }
        Data(f, s, fC, sC)
    }
    val segTree = GeneralSegmentTree.getInstance(
        n = N,
        fx = fx,
        fm = { _, x2 -> x2 },
        ex = Data(0, 0, 0, 0),
    )
    segTree.init(A.map { Data(it, 0, 1, 0) })

    repeat(Q) {
        val (q, a, b) = nextIntList()
        when (q) {
            1 -> segTree.update(a - 1, Data(b, 0, 1, 0))
            2 -> {
                val d = segTree.query(a - 1, b)
                println(d.sCount)
            }
        }
    }
}