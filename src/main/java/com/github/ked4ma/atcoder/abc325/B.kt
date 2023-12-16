package com.github.ked4ma.atcoder.abc325

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val arr = sizedArray(24, 0)
    val N = nextInt()
    repeat(N) {
        val (W, X) = nextIntList()
        for (i in 9 until 18) {
            arr[(X + i) % 24] += W
        }
    }
    println(arr.max())
}