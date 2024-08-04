package com.github.ked4ma.atcoder.abc365

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Y = nextInt()
    if (Y % 4 != 0) {
        println(365)
        return
    }
    if (Y % 4 == 0 && Y % 100 != 0) {
        println(366)
        return
    }
    if (Y % 100 == 0 && Y % 400 != 0) {
        println(365)
    }
    if (Y % 400 == 0) {
        println(366)
    }
}
