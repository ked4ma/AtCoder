package com.github.ked4ma.atcoder.abc377

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = times(8) { nextCharArray() }

    val tate = sizedIntArray(8, 0)
    val yoko = sizedIntArray(8, 0)
    for (i in range(8)) {
        for (j in range(8)) {
            if (S[i][j] == '#') {
                tate[j]++
                yoko[i]++
            }
        }
    }

    var ans = 0
    for (i in range(8)) {
        for (j in range(8)) {
            if (tate[j] > 0 || yoko[i] > 0) continue
            ans++
        }
    }
    println(ans)
}
