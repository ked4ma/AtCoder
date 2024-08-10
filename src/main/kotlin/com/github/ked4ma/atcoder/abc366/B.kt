package com.github.ked4ma.atcoder.abc366

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) { nextCharArray() }
    val M = S.maxOf { it.size }
    repeat(M) { i ->
        val sb = StringBuilder()
        var astCnt = 0
        for (j in S.lastIndex downTo 0) {
            if (i > S[j].lastIndex) {
                astCnt++
            } else {
                sb.append("*".repeat(astCnt))
                sb.append(S[j][i])
                astCnt = 0
            }
        }
        println(sb)
    }
}
