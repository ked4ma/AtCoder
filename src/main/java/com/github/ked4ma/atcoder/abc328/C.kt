package com.github.ked4ma.atcoder.abc328

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val S = next().toCharArray()
    val acc = sizedArray(N, 0)
    for (i in 1 until N) {
        acc[i] = acc[i - 1]
        if (S[i] == S[i - 1]) {
            acc[i]++
        }
    }
    repeat(Q) {
        val (l, r) = nextIntList()
        println(acc[r - 1] - acc[l - 1])
    }
}