package com.github.ked4ma.atcoder.abc371

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.int.bound.*
import com.github.ked4ma.atcoder.utils.list.long.cumlative.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val X = nextIntList()
    val X2 = listOf(Int.MIN_VALUE) + X + listOf(Int.MAX_VALUE)
    _debug_println(X2)
    val P = nextLongList()
    val P2 = listOf(0L) + P + listOf(0L)
    val Q = nextInt()
    val LR = times(Q) {
        val (L, R) = nextIntList()
        X2.lowerBound(L) to X2.upperBound(R) - 1
    }
    val cum = P2.cumulativeSum()

    val ans = mutableListOf<Long>()
    for ((L, R) in LR) {
        ans.add(cum[R + 1] - cum[L])
    }
    println(ans.joinToString("\n"))

//    val fenwickTree = FenwickTree(compressMap.size)
//    for (i in range(N)) {
//        val x2 = compressMap.getValue(X[i])
//        fenwickTree.add(x2, P[i])
//    }

//    val ans = mutableListOf<Long>()
//    repeat(Q) { i ->
//        val (L, R) = LR[i].let { (L, R) -> compressMap.getValue(L) to compressMap.getValue(R) }
//        ans.add(fenwickTree.sum(L, R + 1))
//    }
//    println(ans.joinToString("\n"))
}