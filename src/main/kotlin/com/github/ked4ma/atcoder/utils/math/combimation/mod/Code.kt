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
            fac[i] = fac[i - 1].timesMod(i.toLong(), mod)
            inv[i] = mod - inv[(mod % i).toInt()].timesMod(mod / i, mod)
            finv[i] = finv[i - 1].timesMod(inv[i], mod)
        }
    }

    fun aCb(a: Int, b: Int): Long {
        if (a < b) return 0
        if (a < 0 || b < 0) return 0
        return fac[a].timesMod(finv[b], mod).timesMod(finv[a - b], mod)
    }

    // duplicated combination
    // ref: https://frontiesta.com/homogeneous/#toc2
    // oo|o||ooo -> o:6, |:3
    // split six "o" into 4 groups -> 4H6
    fun nHk(n: Int, k: Int): Long {
        return aCb(n + k - 1, k)
    }
}