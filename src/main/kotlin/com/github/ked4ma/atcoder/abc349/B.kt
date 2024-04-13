package com.github.ked4ma.atcoder.abc349

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val cnt = sizedIntArray(26, 0)
    for (c in S) {
        cnt[c - 'a']++
    }
    val cnt2 = sizedIntArray(S.length + 1, 0)
    for (n in cnt) {
        cnt2[n]++
    }
    _debug_println(cnt2.joinToString(", "))
    println(if ((1..S.length).all { cnt2[it] == 0 || cnt2[it] == 2 }) "Yes" else "No")
}
