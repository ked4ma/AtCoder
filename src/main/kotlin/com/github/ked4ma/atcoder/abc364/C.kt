package com.github.ked4ma.atcoder.abc364

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, Y) = nextLongList().let { (N, X, Y) -> Triple(N.toInt(), X, Y) }
    val A = nextLongList().sortedDescending()
    val B = nextLongList().sortedDescending()

    var aCnt = 0
    var aSum = 0L
    while (aCnt < N && aSum <= X) {
        aSum += A[aCnt]
        aCnt++
    }
    var bCnt = 0
    var bSum = 0L
    while (bCnt < N && bSum <= Y) {
        bSum += B[bCnt]
        bCnt++
    }
    println(min(aCnt, bCnt))
}