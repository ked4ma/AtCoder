package com.github.ked4ma.atcoder.abc330

import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextLongList()
    val A = nextLongList()
    val sj = StringJoiner(" ")
    A.forEach { a ->
        if (a < L) {
            sj.add(L.toString())
        } else if (a in (L..R)) {
            sj.add(a.toString())
        } else {
            sj.add(R.toString())
        }
    }
    println(sj)
}