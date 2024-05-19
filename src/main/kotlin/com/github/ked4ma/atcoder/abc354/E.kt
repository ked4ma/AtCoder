package com.github.ked4ma.atcoder.abc354

import com.github.ked4ma.atcoder.utils.array.boolean.d2.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.number.int.bit.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val cards = times(N) {
        val (A, B) = nextIntList()
        A to B
    }
    _debug_println(1 shl N)
    val dp = sized2DBooleanArray(1 shl N, 2, false)

    for (i in range((1 shl N))) {
        if (i.countOneBits() == 1) continue
        val index = range(N).filter { j -> i.bit(j) }

        for (a in 0 until index.lastIndex) {
            for (b in a + 1 until index.size) {
                val aa = index[a]
                val bb = index[b]
                if (cards[aa].first == cards[bb].first || cards[aa].second == cards[bb].second) {
                    val j = i xor (1 shl aa) xor (1 shl bb)
                    dp[i][0] = dp[i][0] || !dp[j][1]
                    dp[i][1] = dp[i][1] || !dp[j][0]
                }
            }
        }
    }
    _debug_println(dp.map { it[0] }.joinToString(", "))
    _debug_println(dp.map { it[1] }.joinToString(", "))
    println(if (dp.last()[0]) "Takahashi" else "Aoki")
}
