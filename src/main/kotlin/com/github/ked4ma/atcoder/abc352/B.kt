package com.github.ked4ma.atcoder.abc352

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val T = next()
    var i = 0
    var j = 0
    val ans = sizedIntArray(S.length, 0)
    while (i < S.length && j < T.length) {
        if (S[i] == T[j]) {
            ans[i] = j + 1
            i++
        }
        j++
    }
    println(ans.joinToString(" "))
}
