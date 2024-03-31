package com.github.ked4ma.atcoder.abc347

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, A, B) = nextIntList()
    val D = nextIntList().map {
        it % (A + B)
    }.sorted().distinct()
    _debug_println(D)
    range(D.size).any { i ->
        (D[(i + 1) % D.size] - D[i]).mod(A + B) > B
    }.let {
        println(if (it) "Yes" else "No")
    }
}