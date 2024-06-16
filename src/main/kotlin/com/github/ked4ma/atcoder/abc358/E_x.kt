package com.github.ked4ma.atcoder.abc358

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d2.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.math.modinv.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998244353L
    val K = nextInt()
    val C = nextIntList()

    val fac = sizedLongArray(1001, 0)
    val inv = sizedLongArray(1001, 0)
    val facinv = sizedLongArray(1001, 0)
    fun modcalc(n: Int = 1001) {
        fac[0] = 1
        fac[1] = 1
        inv[1] = 1
        facinv[0] = 1
        facinv[1] = 1
        for (i in 2 until n) {
            fac[i] = fac[i - 1].timesMod(i.toLong(), MOD)
            inv[i] = (MOD - inv[(MOD % i).toInt()]).timesMod(MOD / i, MOD)
            facinv[i] = facinv[i - 1].timesMod(inv[i], MOD)
        }
    }
    modcalc()

    fun comb(n: Int, k: Int): Long {
        if (n < 0 || k < 0 || n < k) return 0
        return fac[n].timesMod(facinv[k], MOD).timesMod(facinv[n - k], MOD)
    }

    val dp = sized2DLongArray(27, K + 1, 0)
    dp[0][0] = 1
    for (i in range(26)) {
        for (j in range(K + 1)) {
            for (l in range(min(j, C[i]) + 1)) {
                if (K == 2) _debug_println("$j, $l: ${comb(j, l)}")
                dp[i + 1][j] = dp[i + 1][j].plusMod(dp[i][j - l].timesMod(comb(j, l), MOD), MOD)
            }
        }
    }
    var ans = 0L
    for (i in 1..K) {
        ans = ans.plusMod(dp[26][i], MOD)
    }
    println(ans)
}
