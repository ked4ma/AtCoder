package com.github.ked4ma.atcoder.abc357

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    var u = 0
    var l = 0
    for (s in S) {
        if (s in 'A'..'Z') {
            u++
        } else {
            l++
        }
    }
    println(if (u > l) S.uppercase() else S.lowercase())
}
