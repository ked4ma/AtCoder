package com.github.ked4ma.atcoder.abc374

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var S = next()
    var T = next()

    if (S.length < T.length) {
        S = S + ".".repeat(T.length - S.length)
    } else if (S.length > T.length) {
        T = T + ".".repeat(S.length - T.length)
    }

    for (i in range(S.length)) {
        if (S[i] != T[i]) {
            println(i + 1)
            return
        }
    }
    println(0)
}
