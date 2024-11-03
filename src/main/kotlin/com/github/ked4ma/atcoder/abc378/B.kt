package com.github.ked4ma.atcoder.abc378

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val QR = times(N) {
        val (q, r) = nextIntList()
        q to r
    }
    val Q = nextInt()
    repeat(Q) {
        val (t, d) = nextIntList()
        val (q, r) = QR[t - 1]
        println(((d - r + q - 1) / q) * q + r)
    }
}
