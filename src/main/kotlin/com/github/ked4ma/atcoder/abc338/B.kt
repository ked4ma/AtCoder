package com.github.ked4ma.atcoder.abc338

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val cnt = sizedLongArray(26, 0)
    for (c in S) {
        cnt[c - 'a']++
    }
    var m = 0L
    var ans = 'a'
    repeat(26) {i ->
        if (m < cnt[i]) {
            m = cnt[i]
            ans = 'a' + i
        }
    }
    println(ans)
}