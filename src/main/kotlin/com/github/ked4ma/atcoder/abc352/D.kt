package com.github.ked4ma.atcoder.abc352

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.segment.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val P = nextIntList().map { it - 1 }

    _debug_println(P)
    val maxSegTree = SegmentTree.RUQ_RMQ(N)
    val minSegTree = SegmentTree.RUQ_RmQ(N)
    P.forEachIndexed { i, p ->
        maxSegTree.set(p, i.toLong())
        minSegTree.set(p, i.toLong())
    }
    maxSegTree.build()
    minSegTree.build()

    var ans = Long.MAX_VALUE
    for (i in range(N - K + 1)) {
        _debug_println("$i: ${minSegTree.query(i, i + K)} - ${maxSegTree.query(i, i + K)}")
        ans = min(ans, maxSegTree.query(i, i + K) - minSegTree.query(i, i + K))
    }
    println(ans)
}
