package com.github.ked4ma.atcoder.abc362

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (R, G, B) = nextIntList()
    val C = next()

    println(
        when (C) {
            "Red" -> min(G, B)
            "Green" -> min(R, B)
            "Blue" -> min(R, G)
            else -> -1
        }
    )
}
