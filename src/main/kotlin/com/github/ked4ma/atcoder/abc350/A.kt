package com.github.ked4ma.atcoder.abc350

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val n = S.substring(3).toInt()
    println(
        if (n in 1 until 350 && n != 316) {
            "Yes"
        } else "No"
    )
}
