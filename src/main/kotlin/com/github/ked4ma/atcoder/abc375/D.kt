package com.github.ked4ma.atcoder.abc375

import com.github.ked4ma.atcoder.utils.array.long.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val cnt = sized2DLongArray(26, S.size + 1, 0)
    for (i in range(S.size)) {
        cnt[S[i] - 'A'][i + 1]++
        for (j in range(26)) {
            cnt[j][i + 1] += cnt[j][i]
        }
    }

    var ans = 0L
    for (k in 1 until S.lastIndex) {
        for (c in range(26)) {
            ans += (cnt[c][k] - cnt[c][0]) * (cnt[c][S.size] - cnt[c][k + 1])
        }
    }
    println(ans)
}
