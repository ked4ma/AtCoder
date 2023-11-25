package com.github.ked4ma.atcoder.abc195_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (A, B) = nextLongList()
    val sieve = sizedArray((B - A).toInt() + 1, true)
    for (i in 2..(B - A).toInt()) {
        if (!sieve[i]) continue
        for (j in (i + i)..(B - A).toInt() step i) {
            sieve[j] = false
        }
    }
    val primes = sieve.mapIndexedNotNull { index, b -> if (index >= 2 && b) index else null }
    _debug_println(primes)
    _debug_println(primes.size)

    val msk = sizedArray(73, 0)
    for (x in A..B) {
        val xx = (x - A).toInt()
        for (i in primes.indices) {
            if (x % primes[i] == 0L) {
                msk[xx] += (1 shl i)
            }
        }
    }
    _debug_println(msk.toList())

    val dp = sized2DArray(2, 1 shl 20, 0L)
    dp[0][0] = 1
    for (x in A..B) {
        val xx = (x - A).toInt()
        for (lcm in 0 until (1 shl 20)) {
            dp[(xx + 1) % 2][lcm] = 0
        }
        for (lcm in 0 until (1 shl 20)) {
            if (lcm and msk[xx] == 0) {
                dp[(xx + 1) % 2][lcm or msk[xx]] += dp[xx % 2][lcm]
            }
            dp[(xx + 1) % 2][lcm] += dp[xx % 2][lcm]
        }
    }
    var ans = 0L
    for (lcm in 0 until (1 shl 20)) {
        ans += dp[(B - A + 1).toInt() % 2][lcm]
    }
    println(ans)
}
