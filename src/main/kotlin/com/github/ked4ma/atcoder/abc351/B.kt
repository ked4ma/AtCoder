package com.github.ked4ma.atcoder.abc351

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) {
        next().toCharArray()
    }
    val B = times(N) {
        next().toCharArray()
    }
    for (i in range(N)) {
        for (j in range(N)) {
            if (A[i][j] != B[i][j]) {
                println("${i + 1} ${j + 1}")
                return
            }
        }
    }
}
