package com.github.ked4ma.atcoder.abc354

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val H = nextLong()
    var h = 0L
    var i = 0
    var j = 1L
    while (h <= H) {
        i++
        h += j
        j *= 2
    }
    println(i)
}
