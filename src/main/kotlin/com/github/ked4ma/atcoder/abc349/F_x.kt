package com.github.ked4ma.atcoder.abc349

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.int.pow.*
import com.github.ked4ma.atcoder.utils.math.long.pow.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998_244_353L
    val (N, M) = nextIntList()
    val A = nextLongList()
    val f = buildList {
        var rem = M
        var i = 2
        while (i * i <= rem) {
            if (rem % i == 0) {
                var cnt = 0
                while (rem % i == 0) {
                    cnt++
                    rem /= i
                }
                add(i to cnt)
            }
            i++
        }
        if (rem != 1) {
            add(rem to 1)
        }
    }
    _debug_println(f)
    val K = f.size
    _debug_println(K)
    val cnt = sizedIntArray(1 shl K, 0)
    for (i in A) {
        if (M % i != 0L) continue
        var bit = 0
        for (j in range(K)) {
            val (p, e) = f[j]
            if (i % p.pow(e) == 0L) {
                bit = bit or (1 shl j)
            }
        }
        cnt[bit]++
    }

    var dp = sizedLongArray(1 shl K, 0)
    dp[0] = 1

    _debug_println("dp: " + dp.joinToString(", "))
    for (i in range(1 shl K)) {
        _debug_println(i)
        val ndp = sizedLongArray(1 shl K, 0)
        val c = 2L.powMod(cnt[i].toLong(), MOD) - 1
        for (j in range(1 shl K)) {
            ndp[i or j] += dp[j] * c
            ndp[i or j] %= MOD

            ndp[j] += dp[j]
            ndp[j] %= MOD
        }
        dp = ndp
    }

    _debug_println("dp: " + dp.joinToString(", "))
    var ans = dp[(1 shl K) - 1]
    if (M == 1) {
        ans -= 1
    }
    println(ans % MOD)
}
