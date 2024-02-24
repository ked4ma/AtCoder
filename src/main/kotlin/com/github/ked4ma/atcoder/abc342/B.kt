package com.github.ked4ma.atcoder.abc342

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    val pos = P.mapIndexed { i, p ->
        p to i
    }.toMap()
    val Q = nextInt()
    repeat(Q) {
        val (A, B) = nextIntList()

        println(if (pos.getValue(A) < pos.getValue(B)) A else B)
    }
}