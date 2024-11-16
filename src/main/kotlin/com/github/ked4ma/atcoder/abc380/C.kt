package com.github.ked4ma.atcoder.abc380

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = nextCharArray()

    val ans = StringBuilder()
    val ans2 = StringBuilder()
    var k = 0
    for (i in range(N)) {
        val c = S[i]
        when (c) {
            '0' -> {
                if (k < K - 1) {
                    ans.append(c)
                } else {
                    ans2.append(c)
                }
            }

            '1' -> {
                if (i == 0 || S[i - 1] == '0') k++
                if (k <= K) {
                    ans.append(c)
                } else {
                    ans2.append(c)
                }
            }
        }
    }
    println("$ans$ans2")
}
