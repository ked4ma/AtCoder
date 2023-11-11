package com.github.ked4ma.atcoder.abc328

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val S = next().toMutableList()
    var i = 0
    while (i < S.size) {
        if (S[i] == 'A') {
            i += 2
        } else if (S[i] == 'B') {
            i++
        } else { // 'C'
            if (i >= 2 && S[i - 2] == 'A' && S[i - 1] == 'B' && S[i] == 'C') {
                times(3) {
                    S.removeAt(i - 2)
                }
                i = (i - 4).coerceAtLeast(0)
                continue
            }
            i += 3
        }
    }
    println(S.joinToString(separator = ""))
}