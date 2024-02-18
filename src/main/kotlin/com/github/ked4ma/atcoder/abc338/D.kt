package com.github.ked4ma.atcoder.abc338

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.lazy.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
//    BufferedReader(InputStreamReader(System.`in`)).use { br ->
//        solve(br)
//    }
//}
//
//private fun solve(br: BufferedReader) {
    val (N, M) = nextIntList()
    val X = nextIntList().map { it - 1 }

    val segTree = LazySegmentTree.RAQ_RSQ(N)
    val segTree2 = LazySegmentTree.RAQ_RmQ(N)
    repeat(N) {
        segTree2.set(it, 0)
    }
    segTree2.build()
    for (i in 0 until X.lastIndex) {
        val a: Int
        val b: Int
        if (X[i] > X[i + 1]) {
            a = X[i + 1]
            b = X[i]
        } else {
            a = X[i]
            b = X[i + 1]
        }
        val d1 = b - a
        val d2 = (a - 0) + (N - b)
        if (d1 < d2) {
            segTree.update(a, b, 1L)
            segTree2.update(a, b, (d2 - d1).toLong())
        } else {
            segTree.update(0, a, 1L)
            segTree.update(b, N, 1L)
            segTree2.update(0, a, (d1 - d2).toLong())
            segTree2.update(b, N, (d1 - d2).toLong())
        }
    }
    _debug_println(segTree.query(0, N))
    _debug_println(segTree2.query(0, N))
    println(segTree.query(0, N) + segTree2.query(0, N))
}