package com.github.ked4ma.atcoder.abc329

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    var start = 0
    val ans = sizedArray(26, 0)
    while (start < N) {
        var end = start
        while (end < N && S[start] == S[end]) {
            if (ans[S[start] - 'a'] < end - start + 1) {
                ans[S[start] - 'a'] = end - start + 1
            }
            end++
        }
        start = end
    }
    println(ans.sum())
}