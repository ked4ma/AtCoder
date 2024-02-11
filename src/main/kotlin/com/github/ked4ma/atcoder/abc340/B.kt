package com.github.ked4ma.atcoder.abc340

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val A = mutableListOf<Int>()
    repeat(Q) {
        val q = nextIntList()
        when(q.first()) {
            1 -> A.add(q.last())
            2 -> println(A[A.size - q.last()])
        }
    }
}