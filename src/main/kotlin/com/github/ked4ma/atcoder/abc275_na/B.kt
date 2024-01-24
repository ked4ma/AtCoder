package com.github.ked4ma.atcoder.abc275_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val mod = 998244353L
    val inputs = nextLongList().map { it % mod }
    (inputs[0] // A
        .timesMod(inputs[1], mod) // B
        .timesMod(inputs[2], mod)) // C
        .minusMod(
            inputs[3] // D
                .timesMod(inputs[4], mod) // E
                .timesMod(inputs[5], mod), // F
            mod
        ).let {
            println(it)
        }
}

