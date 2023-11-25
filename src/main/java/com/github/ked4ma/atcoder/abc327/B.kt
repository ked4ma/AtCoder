package com.github.ked4ma.atcoder.abc327

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val B = nextLong()
    var A = 1
    do {
        var n = 1L
        repeat(A) {
            n *= A
        }
        if (n == B) {
            println(A)
            return
        }
        A++
    } while (n < B)
    println(-1)
}