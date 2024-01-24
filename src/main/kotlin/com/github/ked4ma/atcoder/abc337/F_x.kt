package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.array.long.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList()
    val C = sizedLongArray(2 * N + 1, 0L)
    val ALL = sizedLongArray(N + 1, 0L)
    nextLongList().forEachIndexed { i, c ->
        C[i + 1] = c
        C[i + 1 + N] = c
        ALL[c]++
    }

    var ans = 0L
    val cnt = sizedLongArray(N + 1, 0L)
    val box = sizedLongArray(N + 1, 0L)
    var sum = 0L
    fun add(c: Long, x: Long) {
        ans -= min(box[c] * K, ALL[c])
        sum -= box[c]
        box[c] -= (cnt[c] + K - 1) / K
        cnt[c] += x
        box[c] += (cnt[c] + K - 1) / K
        sum += box[c]
        ans += min(box[c] * K, ALL[c])
    }

    var r = 0L
    for (l in 1..N) {
        while (r + 1 < l + N && sum < M) {
            r++
            add(C[r], 1)
        }
        println(ans)
        add(C[l], -1)
    }
}