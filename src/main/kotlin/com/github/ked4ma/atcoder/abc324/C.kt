package com.github.ked4ma.atcoder.abc324

import com.github.ked4ma.atcoder.utils.input.default.*


// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    fun compare(S: String, T: String): Boolean {
        if (S.length > T.length) return compare(T, S)
        var l = 0
        while (l < S.length && S[l] == T[l]) {
            l++
        }
        var r = 0
        while (r < S.length - l && S[S.lastIndex - r] == T[T.lastIndex - r]) {
            r++
        }
        return l + r + 1 >= T.length
    }

    val (N, T2) = nextList().let { (n, t2) -> n.toInt() to t2 }
    val ans = mutableListOf<Int>()
    repeat(N) {
        val S = next()
        if (compare(S, T2)) ans.add(it + 1)
    }
    println(ans.size)
    println(ans.joinToString(separator = " "))
}