package com.github.ked4ma.atcoder.utils.math.combimation.mod

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.math.mod.*

class CombinationMod(n: Int, private val mod: Long = MOD) {
    private val fac = sizedLongArray(n + 1, 0)
    private val finv = sizedLongArray(n + 1, 0)
    private val inv = sizedLongArray(n + 1, 0)

    init {
        fac[0] = 1
        fac[1] = 1
        finv[0] = 1
        finv[1] = 1
        inv[1] = 1
        for (i in 2..n) {
            fac[i] = fac[i - 1] * i
            inv[i] = mod - inv[(mod % i).toInt()] * (mod / i) % mod
            finv[i] = finv[i - 1] * inv[i]
        }
    }

    fun query(n: Int, k: Int): Long {
        if (n < k) return 0
        if (n < 0 || k < 0) return 0
        return (fac[n] * finv[k] * finv[n - k]).mod(mod)
    }
}