package com.github.ked4ma.atcoder.abc350

import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val T = nextIntList().map { it - 1 }

    val state = sizedBooleanArray(N, true)
    repeat(Q) { i ->
        state[T[i]] = !state[T[i]]
    }
    println(state.count { it })
}
