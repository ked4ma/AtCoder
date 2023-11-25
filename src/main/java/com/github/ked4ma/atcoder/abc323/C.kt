package com.github.ked4ma.atcoder.abc323

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import com.github.ked4ma.atcoder.utils.loop.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val S = times(N) {
        next()
    }

    val current = S.mapIndexed { i, s ->
        s.mapIndexed { j, c ->
            if (c == 'o') A[j] else 0
        }.sum() + i + 1
    }
    val max = current.max()
    // max is required
    val A2 = A.withIndex().sortedByDescending { it.value }
    current.forEachIndexed { index, cur ->
        var score = cur
        var count = 0
        var i = 0
        while (score < max) {
            val a = A2[i]
            if (S[index][a.index] == 'x') {
                score += a.value
                count++
            }
            i++
        }
        println(count)
    }
}