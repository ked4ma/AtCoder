package com.github.ked4ma.atcoder.abc324

import com.github.ked4ma.atcoder.utils.input.default.*


// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    var n = nextLong()
    while (n % 2 == 0L) {
        n /= 2
    }
    while (n % 3 == 0L) {
        n /= 3
    }
    println(if (n == 1L) "Yes" else "No")
}