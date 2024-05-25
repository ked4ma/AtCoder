package com.github.ked4ma.atcoder.abc355

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().toSet()
    val B = nextIntList().toSet()
    val C = (A + B).sorted()
    for (i in 0 until C.lastIndex) {
       if (C[i] in A && C[i + 1] in A) {
           println("Yes")
           return
       }
    }
    println("No")
}
