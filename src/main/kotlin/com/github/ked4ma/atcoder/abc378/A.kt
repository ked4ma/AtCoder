package com.github.ked4ma.atcoder.abc378

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = nextIntList().sorted()
    var ans = 0
    var i = 0
    while (i < 3) {
        if (A[i] == A[i + 1]) {
            ans++
            i++
        }
        i++
    }
    println(ans)
}
