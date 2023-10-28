package com.github.ked4ma.atcoder.abc326

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var n = N
    while (true) {
        if ((n / 100) * ((n / 10) % 10) == n % 10) {
            println(n)
            break
        }
        n++
    }
}