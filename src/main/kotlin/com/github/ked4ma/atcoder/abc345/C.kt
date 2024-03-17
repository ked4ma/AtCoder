package com.github.ked4ma.atcoder.abc345

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.combimation.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    var ans = combination(S.length.toLong(), 2)
    var offset = 0
    S.toList().groupingBy { it }.eachCount().forEach { (_, n) ->
        if (n >= 2) {
            offset = 1
            ans -= combination(n.toLong(), 2)
        }
    }

    println(ans + offset)
}