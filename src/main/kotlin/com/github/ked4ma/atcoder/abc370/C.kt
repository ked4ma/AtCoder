package com.github.ked4ma.atcoder.abc370

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val T = nextCharArray()
    val L = S.size
    val ans = mutableListOf<String>()
    for (i in range(L)) {
        if (S[i] <= T[i]) continue
        S[i] = T[i]
        ans.add(S.joinToString(""))
    }
    for (i in range(L).reversed()) {
        if (S[i] == T[i]) continue
        S[i] = T[i]
        ans.add(S.joinToString(""))
    }
    println(ans.size)
    println(ans.joinToString("\n"))
}
