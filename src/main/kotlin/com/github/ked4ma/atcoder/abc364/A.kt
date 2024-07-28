package com.github.ked4ma.atcoder.abc364

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var sweet = 0

    repeat(N) {
        if (sweet == 2) {
            println("No")
            return
        }
        val S = next()
        if (S == "sweet") {
            sweet++
        } else {
            sweet = 0
        }
    }
    println("Yes")
}
